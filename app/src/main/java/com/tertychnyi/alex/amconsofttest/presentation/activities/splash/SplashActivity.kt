package com.tertychnyi.alex.amconsofttest.presentation.activities.splash

import android.os.Bundle
import android.os.Handler
import com.tertychnyi.alex.amconsofttest.R
import com.tertychnyi.alex.amconsofttest.di.component.ViewModelComponent
import com.tertychnyi.alex.amconsofttest.presentation.activities.auth.AuthActivity
import com.tertychnyi.alex.amconsofttest.presentation.activities.main.MainActivity
import com.tertychnyi.alex.amconsofttest.presentation.base.BaseActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        checkSignedIn()
    }

    override fun injectDependency(component: ViewModelComponent) { }

    private fun checkSignedIn() {
        if (getFirebaseAuth().currentUser != null) {
            Handler().postDelayed({
                startActivity(MainActivity.newInstance(this))
                finish()
            }, TIMER)
        }
        else {
            Handler().postDelayed({
                startActivity(AuthActivity.newInstance(this))
                finish()
            }, TIMER)
        }
    }

    companion object {
        private const val TIMER = 3000L
    }
}