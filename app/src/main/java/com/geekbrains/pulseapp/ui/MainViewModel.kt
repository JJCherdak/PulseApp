package com.geekbrains.pulseapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geekbrains.pulseapp.data.Repository
import com.geekbrains.pulseapp.data.RepositoryFake
import com.geekbrains.pulseapp.domain.Item
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel (private val repo: Repository = RepositoryFake()) :
    ViewModel() {
    private val liveDataToObserve: MutableLiveData<List<Item>> = MutableLiveData(listOf())

    fun getData(): LiveData<List<Item>> {
        return liveDataToObserve
    }

    fun requestPosts() = requestPostsFromApi()

    private fun requestPostsFromApi() {
        repo.getItems()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                liveDataToObserve.postValue(it)
            }, {

            })
    }

    fun saveNewItem(item: Item) {
        repo.addItem(item)
    }
}