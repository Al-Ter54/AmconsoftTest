package com.tertychnyi.alex.amconsofttest.usecases.repository.server

import com.tertychnyi.alex.amconsofttest.usecases.repository.database.entity.UserEntity
import com.tertychnyi.alex.amconsofttest.utils.RxUtils
import io.reactivex.Single
import retrofit2.Response

class ServerCommunicator(private val apiService: ApiService) {

    fun fetchUsers(): Single<Response<List<UserEntity>>?> {
        return apiService.fetchUsers()
            .compose(RxUtils.singleTransformer())
    }

}