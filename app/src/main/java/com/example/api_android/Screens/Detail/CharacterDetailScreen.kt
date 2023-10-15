package com.example.api_android.Screens.Detail

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.api_android.data.remote.ThroneInstance
import com.example.api_android.data.remote.ThroneResponce
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
//import javax.security.auth.callback.Callback

@Destination
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(
    navigator: DestinationsNavigator,
    id: Int
) {
    val context = LocalContext.current

    var throneResponce by remember(id){
        mutableStateOf<ThroneResponce?>(null)
    }

    ThroneInstance.ApiService.getCharacters().enqueue(object: Callback<ThroneResponce> {
        override fun onResponse(
            call: Call<ThroneResponce>,
            response: Response<ThroneResponce>)
        {
            throneResponce = response.body()
        }

        override fun onFailure(call: Call<ThroneResponce>, t: Throwable) {
            Toast.makeText(context,"Failed to fetch Character Info", Toast.LENGTH_SHORT).show()
        }
    })

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Character Detail")  },
                navigationIcon = {
                    IconButton(onClick = {
                        navigator.popBackStack()
                    }){
                         Icon(
                             imageVector = Icons.Default.ArrowBack,
                             contentDescription = null,
                         )
                    }
                }
            )
        }
    ){paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {

        }
    }


}