package com.tertychnyi.alex.amconsofttest.di.module

import android.app.Application
import com.tertychnyi.alex.amconsofttest.App
import com.tertychnyi.alex.amconsofttest.di.scope.ViewModelScope
import com.tertychnyi.alex.amconsofttest.domain.ListUsersViewModel
import com.tertychnyi.alex.amconsofttest.domain.OneUserViewModel
import com.tertychnyi.alex.amconsofttest.usecases.UsersInteractor
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(app: App) {

    internal var app: Application = app

    @ViewModelScope
    @Provides
    internal fun providesAllUserViewModel(interactor: UsersInteractor): ListUsersViewModel {
        return ListUsersViewModel(app, interactor)
    }

    @ViewModelScope
    @Provides
    internal fun providesSingleViewModel(interactor: UsersInteractor): OneUserViewModel {
        return OneUserViewModel(app, interactor)
    }
}