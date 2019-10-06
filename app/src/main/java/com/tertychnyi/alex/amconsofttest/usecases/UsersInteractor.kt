package com.tertychnyi.alex.amconsofttest.usecases

import android.util.Log
import com.tertychnyi.alex.amconsofttest.usecases.repository.UsersRepository
import com.tertychnyi.alex.amconsofttest.usecases.repository.database.entity.UserEntity
import com.tertychnyi.alex.amconsofttest.utils.Constants
import io.reactivex.Single

class UsersInteractor(private val repository: UsersRepository) {

    fun fetchUsers(): Single<List<UserEntity>> {
        return repository.fetchUsers()
            .doOnError { t -> Log.e(Constants.TAG_ERROR, t.message) }
    }

    fun fetchUserById(id: Int): Single<UserEntity> {
        return repository.fetchUserById(id)
            .doOnError { t -> Log.e(Constants.TAG_ERROR, t.message) }
    }
}