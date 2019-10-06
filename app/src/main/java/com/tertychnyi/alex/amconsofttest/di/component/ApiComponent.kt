package com.tertychnyi.alex.amconsofttest.di.component

import com.tertychnyi.alex.amconsofttest.di.module.ApiModule
import com.tertychnyi.alex.amconsofttest.di.scope.ApiScope
import com.tertychnyi.alex.amconsofttest.usecases.repository.server.ServerCommunicator
import dagger.Component

@ApiScope
@Component(modules = [ApiModule::class])
interface ApiComponent {
    val serverCommunicator: ServerCommunicator
}