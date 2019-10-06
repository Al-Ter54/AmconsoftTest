package com.tertychnyi.alex.amconsofttest.usecases.repository

import com.tertychnyi.alex.amconsofttest.usecases.repository.database.UsersDatabase
import com.tertychnyi.alex.amconsofttest.usecases.repository.database.entity.UserEntity
import com.tertychnyi.alex.amconsofttest.usecases.repository.server.ServerCommunicator
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UsersRepository(private val communicator: ServerCommunicator, private val database: UsersDatabase) {

    fun fetchUsers(): Single<List<UserEntity>> {
        return communicator.fetchUsers()
            .flatMap { response ->
                if (response.isSuccessful) {
                    database.userDao().insertList(response.body()!!)
                }
                Single.just(database.userDao().getAll())
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun fetchUserById(id: Int): Single<UserEntity> {
        return Single.just(database.userDao().getById(id))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}