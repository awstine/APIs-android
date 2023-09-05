package com.example.api_android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
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

                ThroneInstance.ApiService.getCharacters().enqueue(object : Callback<List<ThroneResponce>>{
                    override fun onResponse(
                        call: Call<List<ThroneResponce>>,
                        response: Response<List<ThroneResponce>>
                    ) {
                        Toast.makeText(context,"Api call Successful --Bahati Yako--", Toast.LENGTH_SHORT).show()

                    }

                    override fun onFailure(call: Call<List<ThroneResponce>>, t: Throwable) {
                        Toast.makeText(context,"Api call Failed Terribly", Toast.LENGTH_SHORT).show()
                    }

                })

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
