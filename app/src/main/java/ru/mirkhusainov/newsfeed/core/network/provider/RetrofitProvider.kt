package ru.mirkhusainov.newsfeed.core.network.provider

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.mirkhusainov.newsfeed.core.di.Endpoint
import javax.inject.Inject
import javax.inject.Provider

class RetrofitProvider @Inject constructor(@Endpoint private val endpoint: String) :
    Provider<Retrofit> {
    override fun get(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(endpoint)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}