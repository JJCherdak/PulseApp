package com.geekbrains.pulseapp.domain

import android.annotation.SuppressLint
import io.reactivex.rxjava3.core.Single
import java.text.SimpleDateFormat
import java.util.*

class FakeRepo {
    @SuppressLint("SimpleDateFormat")
    val timeFormat = SimpleDateFormat("hh:mm")
    @SuppressLint("SimpleDateFormat")
    val dateFormat = SimpleDateFormat("dd MMM")

    private val list: MutableList<Item> = mutableListOf(
        Item(0,"15 May","02:23",137,82,59),
        Item(1,"15 May","12:13",127,77,69),
        Item(2,"16 May","05:52",142,61,54),
        Item(3,"16 May","13:54",134,78,63),
        Item(4,"17 May","01:41",133,72,59),
        Item(5,"17 May","22:23",125,63,62),
        Item(6,"18 May","02:26",136,71,59),
        Item(7,"18 May","16:33",126,67,54),
        Item(8,"18 May","23:27",141,64,63),
        Item(9,"19 May","02:23",127,73,58),
        Item(10, dateFormat.format(Date()).toString(), timeFormat.format(Date()).toString(),150,83,55),
        Item(11, dateFormat.format(Date()).toString(), timeFormat.format(Date()).toString(),129,79,54)
    )

    fun getList(): Single<List<Item>> = Single.just(list)
    fun addItem(item: Item) {
        list.add(item)
    }
}