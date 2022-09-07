package com.geekbrains.pulseapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.pulseapp.domain.Item
import com.geekbrains.pulseapp.databinding.RecyclerItemBinding

class MainRecyclerAdapter:

    RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>() {

    private var dataItems: List<Item> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = RecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(dataItems[position], position)
    }

    override fun getItemCount(): Int {
        return dataItems.size
    }

    inner class MainViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item, position: Int) {
            binding.apply {
                if (position != 0) if (dataItems[position - 1].data == item.data) {
                    data.visibility = View.GONE
                    line.visibility = View.GONE
                }
                time.text = item.time
                data.text = item.data
                pressure1.text = item.firstPressure.toString()
                pressure2.text = item.secondPressure.toString()
                pulse.text = item.pulse.toString()
            }
        }
    }

    fun addItem(item: Item) {
        dataItems = dataItems + item
        notifyItemInserted(dataItems.size - 1)
    }

    fun setData(data: List<Item>) {
        dataItems = data
        notifyDataSetChanged()
    }
}