package com.tertychnyi.alex.amconsofttest.di.component

import com.tertychnyi.alex.amconsofttest.di.module.DatabaseModule
import com.tertychnyi.alex.amconsofttest.usecases.repository.database.UsersDatabase
import dagger.Component

@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    val database: UsersDatabase
}