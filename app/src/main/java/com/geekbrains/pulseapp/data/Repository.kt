package com.geekbrains.pulseapp.data


import io.reactivex.rxjava3.core.Single
import com.geekbrains.pulseapp.domain.Item



interface Repository {

    fun getItems() : Single<List<Item>>
    fun addItem(item: Item) : Single<List<Item>>
}