package ru.mirkhusainov.newsfeed.core.di.modules

import android.content.Context
import ru.mirkhusainov.newsfeed.BuildConfig
import ru.mirkhusainov.newsfeed.core.di.ApiKey
import ru.mirkhusainov.newsfeed.core.di.Endpoint
import ru.mirkhusainov.newsfeed.core.resources.ResourceProvider
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.config.Module

class AppModule(context: Context) : Module() {
    init {
        bind(Context::class.java).toInstance(context)
        bind(String::class.java).withName(Endpoint::class.java).toInstance(BuildConfig.ENDPOINT)
        bind(String::class.java).withName(ApiKey::class.java).toInstance(BuildConfig.API_KEY)
        bind(ResourceProvider::class.java).singleton()

        val cicerone = Cicerone.create()
        bind(Router::class.java).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).toInstance(cicerone.navigatorHolder)


    }
}