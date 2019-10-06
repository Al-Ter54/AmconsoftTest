package com.tertychnyi.alex.amconsofttest.di.module

import com.tertychnyi.alex.amconsofttest.di.scope.RepositoryScope
import com.tertychnyi.alex.amconsofttest.usecases.repository.UsersRepository
import com.tertychnyi.alex.amconsofttest.usecases.repository.database.UsersDatabase
import com.tertychnyi.alex.amconsofttest.usecases.repository.server.ServerCommunicator
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @RepositoryScope
    @Provides
    internal fun providesRepository(communicator: ServerCommunicator, database: UsersDatabase): UsersRepository {
        return UsersRepository(communicator, database)
    }
}