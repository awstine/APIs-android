package com.example.api_android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
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
              //  DestinationNavHost(navGraph = NavGraphs.root)


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
