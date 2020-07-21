package com.androidskeleton.module.ui.splash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.androidskeleton.module.ui.main.MainActivity

class SplashActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}