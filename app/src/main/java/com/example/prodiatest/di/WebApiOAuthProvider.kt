package com.example.prodiatest.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object WebApiOAuthProvider {
    fun getRetrofit(url: String): Retrofit = Retrofit
        .Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(
            OkHttpClient()
                .newBuilder()
                .addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                )
                .readTimeout(80, TimeUnit.SECONDS)
                .writeTimeout(90, TimeUnit.SECONDS)
                .connectTimeout(80, TimeUnit.SECONDS)
                .build()
        )
        .build()
}