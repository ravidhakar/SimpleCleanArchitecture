package com.cleanarchitectureexample

import android.app.Application
import android.content.Context

class MyApp : Application() {
    companion object {
        private var _context: Context? = null
        val context: Context? get() = _context;
    }

    override fun onCreate() {
        super.onCreate()
        _context = this.applicationContext
    }
}