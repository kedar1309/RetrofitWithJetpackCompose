package com.example.retrofitjetpackcompose.repository

import com.example.retrofitjetpackcompose.model.RouterInfo
import com.example.retrofitjetpackcompose.network.RouterApi
import javax.inject.Inject

class RouterRepository @Inject constructor(val routerApi: RouterApi) {
    suspend fun getRouterInfo() : List<RouterInfo> =  listOf(RouterInfo("name1", "123.1.1.1", "Router"),
        RouterInfo("name2", "123.1.1.1", "Router"),
        RouterInfo("name3", "123.1.1.2", "Extender"),
        RouterInfo("name4", "123.1.1.3", "Router"),
        RouterInfo("name5", "123.1.1.4", "Home device"),
        RouterInfo("name6", "123.1.1.5", "Alexa")
        ) //routerApi.getListOfRouterInfo()
}