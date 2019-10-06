package com.tertychnyi.alex.amconsofttest.di.component

import com.tertychnyi.alex.amconsofttest.di.module.ViewModelModule
import com.tertychnyi.alex.amconsofttest.di.scope.ViewModelScope
import com.tertychnyi.alex.amconsofttest.presentation.activities.detail.DetailActivity
import com.tertychnyi.alex.amconsofttest.presentation.activities.main.MainActivity
import dagger.Component

@ViewModelScope
@Component(modules = [ViewModelModule::class], dependencies = [InteractorComponent::class])
interface ViewModelComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: DetailActivity)
}