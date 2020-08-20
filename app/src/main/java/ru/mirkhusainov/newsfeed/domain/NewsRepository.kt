package ru.mirkhusainov.newsfeed.domain

import io.reactivex.Single
import ru.mirkhusainov.newsfeed.data.network.NewsApi
import ru.mirkhusainov.newsfeed.data.network.model.NewsResponse
import javax.inject.Inject

private const val DEFAULT_QUERY = "android"
private const val DEFAULT_FROM = "2019-04-00"
private const val DEFAULT_SORT_TYPE = "publishedAt"

class NewsRepository @Inject constructor(private val newsApi: NewsApi) {

    fun getNewsAboutAndroid(page: Int): Single<NewsResponse> =
        newsApi.getEverything(DEFAULT_QUERY, DEFAULT_FROM, DEFAULT_SORT_TYPE, page.toString())
}