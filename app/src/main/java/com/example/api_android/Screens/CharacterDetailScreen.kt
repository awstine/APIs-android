package com.example.api_android.Screens

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.api_android.data.remote.ThroneInstance
import com.example.api_android.data.remote.ThroneResponce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
//import javax.security.auth.callback.Callback

//@Destination
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(
    //navigator: DestinationNavigator,
    id: Int
) {
    val context = LocalContext.current
    var ThroneResponce by remember(id){
        mutableStateOf<ThroneResponce?>(null)
    }

    ThroneInstance.ApiService.characterById().enqueue(object : Callback<List<ThroneResponce>> {
        override fun onResponce(
            call: Call<ThroneResponce>,
            responce: Response<ThroneResponce>
        ){
            ThroneResponce = responce.body()
        }

        override fun onFailure(call: Call<ThroneResponce>, t: Throwable) {
            Toast.makeText(context,"Failed to fetch Character Info", Toast.LENGTH_SHORT).show()
        }

        override fun onFailure(call: Call<List<ThroneResponce>>, t: Throwable) {
            TODO("Not yet implemented")
        }

        override fun onResponse(
            call: Call<List<ThroneResponce>>,
            response: Response<List<ThroneResponce>>
        ) {
            TODO("Not yet implemented")
        }
    })

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Character Detail")  },
                navigationIcon = {
                    IconButton(onClick = {
                       // navigator.popBackStack()
                    }){
                        // Icon()
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