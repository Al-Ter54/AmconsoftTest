package com.tertychnyi.alex.amconsofttest.presentation.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.tertychnyi.alex.amconsofttest.App
import com.tertychnyi.alex.amconsofttest.R
import com.tertychnyi.alex.amconsofttest.di.component.ViewModelComponent

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDaggerDependencies()
    }

    override fun startActivity(intent: Intent) {
        super.startActivity(intent)
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down)
    }

    protected fun getFirebaseAuth(): FirebaseAuth {
        return (application as App).getFirebaseAuth()
    }

    protected abstract fun injectDependency(component: ViewModelComponent)

    private fun createDaggerDependencies() {
        injectDependency((application as App).getViewModelComponent())
    }
}