package io.gads.payrocket.ui.splash

import android.content.Intent

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import io.gads.payrocket.ui.MainActivity
import android.content.SharedPreferences
import dagger.hilt.android.AndroidEntryPoint

import io.gads.payrocket.common.Constants.HAS_COMPLETED_ONBOARDING
import io.gads.payrocket.ui.onboarding.OnBoardingActivity
import javax.inject.Inject


@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    @Inject
    lateinit var sharedPrefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initUi()
        Handler(Looper.getMainLooper()).postDelayed({
            initUi()
        }, 1000)
    }
    private fun initUi(){
        hasCompletedOnBoarding()
    }

    //check if user has completed the on boarding orientation previously
    private fun hasCompletedOnBoarding(){
        if (sharedPrefs.getBoolean(HAS_COMPLETED_ONBOARDING, false)){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        else {
            startActivity(Intent(this, OnBoardingActivity::class.java))
            finish()
        }

    }
}