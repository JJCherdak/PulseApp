package com.geekbrains.pulseapp.data
import com.geekbrains.pulseapp.domain.Item
import com.geekbrains.pulseapp.domain.FakeRepo
import io.reactivex.rxjava3.core.Single


class RepositoryFake (private val repo: FakeRepo = FakeRepo()) : Repository {


    override fun getItems() : Single<List<Item>> {
        return repo.getList()
    }

    override fun addItem(item: Item) {
        repo.addItem(item)
    }
}