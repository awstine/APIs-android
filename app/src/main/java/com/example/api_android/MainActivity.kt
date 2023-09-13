package com.example.api_android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.api_android.data.remote.ThroneInstance
import com.example.api_android.data.remote.ThroneResponce
import com.example.api_android.ui.theme.APIandroidTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            APIandroidTheme {

                val context = LocalContext.current /* --CALLED BEFOR MAKING OR CALLING TOASTS-- */
                var ThroneResponce:List<ThroneResponce>? by remember{
                    mutableStateOf( emptyList())
                }


                ThroneInstance.ApiService.getCharacters().enqueue(object : Callback<List<ThroneResponce>>{
                    override fun onResponse(
                        call: Call<List<ThroneResponce>>,
                        response: Response<List<ThroneResponce>>
                    ) {
                        //IF RESPONCE BODY IS SUCCESFUL THEN...

                        ThroneResponce = response.body()
                    }

                    override fun onFailure(call: Call<List<ThroneResponce>>, t: Throwable) {
                        Toast.makeText(context,"Api call Failed Terribly", Toast.LENGTH_SHORT).show()
                    }

                })

                if (!ThroneResponce.isNullOrEmpty()){
                    LazyColumn {
                        items(ThroneResponce!!){ Throne ->
                            GameOfThronesCharacters(ThroneResponce = Throne)
                        }
                    }
                }else{
                    CircularProgressIndicator()
                }

//                ThroneInstance.ApiService.getAllContinents().enqueue(object : Callback<List<ThroneResponce>>{
//                    override fun onResponse(
//                        call: Call<List<ThroneResponce>>,
//                        response: Response<List<ThroneResponce>>
//                    ) {
//                        Toast.makeText(context,"Api call Successful", Toast.LENGTH_SHORT).show()
//
//                    }
//
//                    override fun onFailure(call: Call<List<ThroneResponce>>, t: Throwable) {
//                        Toast.makeText(context,"Api call Failed ", Toast.LENGTH_SHORT).show()
//                    }
//
//                })
            }
        }
    }
}

@Composable
fun GameOfThronesCharacters(ThroneResponce: ThroneResponce) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(9.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),

        ) {
            AsyncImage(
                model = ThroneResponce.image,
                contentDescription = null,
            )
            Text(text = "ID: ${ThroneResponce.id.toString()}", fontSize = 20.sp)
            Text(text = "Full name: ${ThroneResponce.fullName}", fontSize = 20.sp)
            Text(text = "Title: ${ThroneResponce.title}", fontSize = 20.sp)
            Text(text = "Family: ${ThroneResponce.family}", fontSize = 20.sp)
            Text(text = "Image URL: ${ThroneResponce.imageUrl}", fontSize = 20.sp)
        }
    }
}