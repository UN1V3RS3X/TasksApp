package com.example.tasksapp.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tasksapp.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }
}