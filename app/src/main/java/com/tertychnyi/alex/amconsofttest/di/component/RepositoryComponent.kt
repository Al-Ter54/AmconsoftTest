package com.tertychnyi.alex.amconsofttest.di.component

import com.tertychnyi.alex.amconsofttest.di.module.RepositoryModule
import com.tertychnyi.alex.amconsofttest.di.scope.RepositoryScope
import com.tertychnyi.alex.amconsofttest.usecases.repository.UsersRepository
import dagger.Component

@RepositoryScope
@Component(modules = [RepositoryModule::class], dependencies = [ApiComponent::class, DatabaseComponent::class])
interface RepositoryComponent {
    val repository: UsersRepository
}