package ru.mirkhusainov.newsfeed.core.di

import android.content.Context
import ru.mirkhusainov.newsfeed.core.di.modules.AppModule
import ru.mirkhusainov.newsfeed.core.di.modules.NetworkModule
import toothpick.Toothpick

object DiMain {
    fun initAppScope(context: Context) {
        Toothpick.openScope(Scopes.SCOPE_APP).installModules(AppModule(context), NetworkModule())
    }
}