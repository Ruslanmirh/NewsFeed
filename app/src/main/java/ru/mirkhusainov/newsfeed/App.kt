package ru.mirkhusainov.newsfeed

import android.app.Application
import ru.mirkhusainov.newsfeed.core.di.DiMain

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDi()
    }

    private fun initDi() {
        DiMain.initAppScope(this)
    }
}