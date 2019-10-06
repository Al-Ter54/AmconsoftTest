package com.tertychnyi.alex.amconsofttest

import android.app.Application
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.tertychnyi.alex.amconsofttest.di.component.*
import com.tertychnyi.alex.amconsofttest.di.module.*
import com.tertychnyi.alex.amconsofttest.usecases.repository.database.UsersDatabase

class App: Application() {

    private var viewModelComponent: ViewModelComponent? = null
    private var database: UsersDatabase? = null
    private var firebaseAuth: FirebaseAuth? = null

    override fun onCreate() {
        super.onCreate()
        initFirebaseAuth()
        initRoom()
        initDagger()
    }

    fun getViewModelComponent(): ViewModelComponent {
        return this!!.viewModelComponent!!
    }

    fun getFirebaseAuth(): FirebaseAuth {
        return this!!.firebaseAuth!!
    }

    private fun initRoom() {
        database = Room.databaseBuilder(this, UsersDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }

    private fun initDagger() {
        val apiComponent = DaggerApiComponent.builder()
            .apiModule(ApiModule())
            .build()

        val databaseComponent = DaggerDatabaseComponent.builder()
            .databaseModule(DatabaseModule(this!!.database!!))
            .build()

        val repositoryComponent = DaggerRepositoryComponent.builder()
            .apiComponent(apiComponent)
            .databaseComponent(databaseComponent)
            .repositoryModule(RepositoryModule())
            .build()

        val interactorComponent = DaggerInteractorComponent.builder()
            .repositoryComponent(repositoryComponent)
            .interactorModule(InteractorModule())
            .build()

        viewModelComponent = DaggerViewModelComponent.builder()
            .interactorComponent(interactorComponent)
            .viewModelModule(ViewModelModule(this))
            .build()
    }

    private fun initFirebaseAuth() {
        firebaseAuth = FirebaseAuth.getInstance()
    }
}