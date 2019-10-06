package com.tertychnyi.alex.amconsofttest.domain

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.LiveData
import com.tertychnyi.alex.amconsofttest.presentation.widget.SingleLiveEvent
import com.tertychnyi.alex.amconsofttest.usecases.UsersInteractor
import com.tertychnyi.alex.amconsofttest.usecases.repository.database.entity.UserEntity

class ListUsersViewModel(app: Application, private val interactor: UsersInteractor): BaseViewModel(app) {

    private val liveDataItems = SingleLiveEvent<List<UserEntity>>()

    @SuppressLint("CheckResult")
    fun getAllItems() {
        interactor.fetchUsers()?.subscribe({ list -> liveDataItems.value = list }, { liveDataItems.value = null })
    }

    fun getLiveDataItems(): LiveData<List<UserEntity>> {
        return liveDataItems
    }
}