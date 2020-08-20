package ru.mirkhusainov.newsfeed.data.network.provider

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.mirkhusainov.newsfeed.core.di.ApiKey
import ru.mirkhusainov.newsfeed.core.di.Endpoint
import javax.inject.Inject
import javax.inject.Provider

class RetrofitProvider @Inject constructor(
    @Endpoint private val endpoint: String,
    @ApiKey private val apiKey: String
) :
    Provider<Retrofit> {
    override fun get(): Retrofit {
        return Retrofit.Builder()
            .client(createOkHttpClient())
            .baseUrl(endpoint)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun createOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request()
            val url = request.url().newBuilder().addQueryParameter("apiKey", apiKey).build()
            chain.proceed(request.newBuilder().url(url).build())
        }.build()
}