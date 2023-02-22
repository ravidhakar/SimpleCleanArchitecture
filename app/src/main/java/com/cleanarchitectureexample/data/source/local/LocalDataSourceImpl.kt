package com.cleanarchitectureexample.data.source.local

import android.content.Context
import com.cleanarchitectureexample.MyApp

class LocalDataSourceImpl :LocalDataSource {
    private val PREF_NAME="MY_PREF"
    private val COUNT="COUNT"
    override suspend fun updateCount(count: Int) {
       MyApp.context?.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)?.edit()?.putInt(COUNT,count)?.apply()
    }

    override suspend fun getCount(): Int {
       return  MyApp.context?.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)?.getInt(COUNT,0)?:0
    }
}