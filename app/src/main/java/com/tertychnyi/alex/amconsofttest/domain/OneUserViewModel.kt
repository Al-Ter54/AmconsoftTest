package com.tertychnyi.alex.amconsofttest.domain

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.LiveData
import com.tertychnyi.alex.amconsofttest.presentation.widget.SingleLiveEvent
import com.tertychnyi.alex.amconsofttest.usecases.UsersInteractor
import com.tertychnyi.alex.amconsofttest.usecases.repository.database.entity.UserEntity

class OneUserViewModel (app: Application, private val interactor: UsersInteractor): BaseViewModel(app) {

    private val liveDataItem = SingleLiveEvent<UserEntity>()

    @SuppressLint("CheckResult")
    fun getUser(id: Int) {
        interactor.fetchUserById(id)?.subscribe { item -> liveDataItem.value = item }
    }

    fun getLiveDataItem(): LiveData<UserEntity> {
        return liveDataItem
    }
}