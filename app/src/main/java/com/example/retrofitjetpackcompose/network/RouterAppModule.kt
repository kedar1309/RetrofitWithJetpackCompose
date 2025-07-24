package com.example.retrofitjetpackcompose.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RouterAppModule {

    @Provides
    @Singleton
    fun getRouterInfo() : Retrofit =
        Retrofit.Builder().baseUrl("http://yourserverurl.com").addConverterFactory(
            GsonConverterFactory.create()).build()


    @Provides
    @Singleton
    fun provideRouterApi(retrofit: Retrofit) : RouterApi = retrofit.create(RouterApi::class.java)

}