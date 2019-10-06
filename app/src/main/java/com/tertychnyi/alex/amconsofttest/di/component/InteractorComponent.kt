package com.tertychnyi.alex.amconsofttest.di.component

import com.tertychnyi.alex.amconsofttest.di.module.InteractorModule
import com.tertychnyi.alex.amconsofttest.di.scope.InteractorScope
import com.tertychnyi.alex.amconsofttest.usecases.UsersInteractor
import dagger.Component

@InteractorScope
@Component(modules = [InteractorModule::class], dependencies = [RepositoryComponent::class])
interface InteractorComponent {
    val interactor: UsersInteractor
}