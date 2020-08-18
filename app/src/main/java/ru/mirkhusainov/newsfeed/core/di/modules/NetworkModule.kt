package ru.mirkhusainov.newsfeed.core.di.modules

import retrofit2.Retrofit
import ru.mirkhusainov.newsfeed.core.network.NewsApi
import ru.mirkhusainov.newsfeed.core.network.provider.NewsApiProvider
import ru.mirkhusainov.newsfeed.core.network.provider.RetrofitProvider
import toothpick.config.Module

class NetworkModule : Module() {
    init {
        bind(Retrofit::class.java).toProvider(RetrofitProvider::class.java)
        bind(NewsApi::class.java).toProvider(NewsApiProvider::class.java)
    }
}