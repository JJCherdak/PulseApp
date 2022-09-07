package com.geekbrains.pulseapp.data

import com.geekbrains.pulseapp.domain.Item
import io.reactivex.rxjava3.core.Single
import com.geekbrains.pulseapp.data.api.Retrofit
import com.geekbrains.pulseapp.data.api.ApiService

class RepositoryImpl (private val api: ApiService = Retrofit().getService()) : Repository {

    override fun getItems(): Single<List<Item>> {
        return api.getItems()
    }

    override fun addItem(item: Item): Single<List<Item>> {
        return api.postItem(
            item.date,
            item.time,
            item.firstPressure,
            item.secondPressure,
            item.pulse
        )
    }
}
