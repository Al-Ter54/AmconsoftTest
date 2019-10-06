package com.tertychnyi.alex.amconsofttest.di.module

import com.tertychnyi.alex.amconsofttest.usecases.repository.database.UsersDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule(private val usersDatabase: UsersDatabase) {
    @Provides
    internal fun providesRoomDatabase(): UsersDatabase {
        return usersDatabase
    }
}