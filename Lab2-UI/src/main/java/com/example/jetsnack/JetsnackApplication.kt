package com.example.jetsnack

import android.app.Application
import com.example.jetsnack.data.AppContainer
import com.example.jetsnack.data.DefaultAppContainer

class JetsnackApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}