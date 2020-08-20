package ru.mirkhusainov.newsfeed.data.network.provider

import retrofit2.Retrofit
import ru.mirkhusainov.newsfeed.data.network.NewsApi
import javax.inject.Inject
import javax.inject.Provider

class NewsApiProvider @Inject constructor(val retrofit: Retrofit) : Provider<NewsApi> {
    override fun get(): NewsApi {
        return retrofit.create(NewsApi::class.java)
    }
}