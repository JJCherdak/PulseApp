package com.geekbrains.pulseapp.ui

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.geekbrains.pulseapp.R
import com.geekbrains.pulseapp.databinding.ActivityMainBinding
import com.geekbrains.pulseapp.databinding.NewItemDialogLayoutBinding
import com.geekbrains.pulseapp.domain.Item
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding
    private val adapter = MainRecyclerAdapter()
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        initRecycler()
        initFabListener()
    }

    private fun initFabListener() {
        bind.fab.setOnClickListener { showNewItemDialog() }
    }

    private fun initRecycler() {
        val observer = Observer<List<Item>> {
            adapter.setData(it)
        }
        bind.recycler.adapter = adapter
        viewModel.getData().observe(this, observer)
        viewModel.requestPosts()
    }

    private fun showNewItemDialog() {
        val dialog = Dialog(this)
        val filterBinding = NewItemDialogLayoutBinding.inflate(layoutInflater)
        dialog.setContentView(filterBinding.root)
        dialog.show()

        filterBinding.btn.setOnClickListener {
            @SuppressLint("SimpleDateFormat")
            val timeFormat = SimpleDateFormat("hh:mm")

            @SuppressLint("SimpleDateFormat")
            val dateFormat = SimpleDateFormat("dd MMM")

            val newItem = Item(
                0,
                dateFormat.format(Date()).toString(),
                timeFormat.format(Date()).toString(),
                filterBinding.pressure1.text.toString().toInt(),
                filterBinding.pressure2.text.toString().toInt(),
                filterBinding.pulse.text.toString().toInt()
            )

            viewModel.saveNewItem(newItem)
            dialog.cancel()
        }
    }
}