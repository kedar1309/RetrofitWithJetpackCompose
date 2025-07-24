package com.example.retrofitjetpackcompose.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitjetpackcompose.model.RouterInfo
import com.example.retrofitjetpackcompose.repository.RouterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RouterViewModel @Inject constructor(routerRepository: RouterRepository) : ViewModel(){


    var routerList by mutableStateOf<List<RouterInfo>>(emptyList())
        private set

    var loading by mutableStateOf<Boolean>(true)
        private set

    init {
        viewModelScope.launch {
            try{
                delay(2000)
                routerList=  routerRepository.getRouterInfo()
            }catch (e : Exception){
                loading = false
            }finally {
                loading = false
            }
        }

    }
}