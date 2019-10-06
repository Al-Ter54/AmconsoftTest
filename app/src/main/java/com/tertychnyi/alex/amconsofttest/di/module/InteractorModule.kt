package com.tertychnyi.alex.amconsofttest.di.module

import com.tertychnyi.alex.amconsofttest.di.scope.InteractorScope
import com.tertychnyi.alex.amconsofttest.usecases.UsersInteractor
import com.tertychnyi.alex.amconsofttest.usecases.repository.UsersRepository
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {
    @InteractorScope
    @Provides
    internal fun providesInteractor(repository: UsersRepository): UsersInteractor {
        return UsersInteractor(repository)
    }
}