package ru.mirkhusainov.newsfeed.data.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.mirkhusainov.newsfeed.data.network.model.NewsResponse

interface NewsApi {

    @GET("everything")
    fun getEverything(
        @Query("q") q: String,
        @Query("from") from: String,
        @Query("publishedAt") publishedAt: String,
        @Query("page") page: String
    ): Single<NewsResponse>
}