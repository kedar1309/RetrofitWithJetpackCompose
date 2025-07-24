package com.example.retrofitjetpackcompose.network

import com.example.retrofitjetpackcompose.model.RouterInfo
import retrofit2.http.GET

interface  RouterApi {

    @GET("routerInfo")
    suspend fun getListOfRouterInfo(): List<RouterInfo>
}