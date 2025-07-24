package com.example.retrofitjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.retrofitjetpackcompose.model.RouterInfo
import com.example.retrofitjetpackcompose.ui.theme.RetrofitJetpackComposeTheme
import com.example.retrofitjetpackcompose.viewmodel.RouterViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetrofitJetpackComposeTheme {
               /* Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    DisplayRouterList()
                }*/
                DisplayRouterList()
            }
        }
    }
}


@Composable
fun DisplayRouterList(viewModel: RouterViewModel = hiltViewModel()){
    if(viewModel.loading) {
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }
    else{
        Column (modifier = Modifier.padding(top = 30.dp)) {
            LazyColumn {
                items(viewModel.routerList) {
                    router -> rowDisplay(router)
                }
            }
        }
    }
}

@Composable
fun rowDisplay( routerInfo : RouterInfo){
    Card (modifier =  Modifier.fillMaxWidth().padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)) {
        Column (modifier = Modifier.padding(4.dp)) {
            Text(text = routerInfo.name )
            Text(text = routerInfo.type )
            Text(text = routerInfo.macId )
        }

    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetrofitJetpackComposeTheme {
        Greeting("Android")
    }
}