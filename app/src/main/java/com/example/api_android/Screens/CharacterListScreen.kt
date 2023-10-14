package com.example.api_android.Screens

//import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
//import com.example.api_android.GameOfThronesCharacters
import com.example.api_android.data.remote.ThroneInstance
import com.example.api_android.data.remote.ThroneResponce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//@Destination
//@RootNavGraph(start = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(
   // navigator: DestinationNavigator
) {
    val context = LocalContext.current /* --CALLED BEFOR MAKING OR CALLING TOASTS-- */
    var ThroneResponce: List<ThroneResponce>? by remember {
        mutableStateOf(emptyList())
    }


    ThroneInstance.ApiService.getCharacters().enqueue(object : Callback<List<ThroneResponce>> {
        override fun onResponse(
            call: Call<List<ThroneResponce>>,
            response: Response<List<ThroneResponce>>
        ) {
            //IF RESPONCE BODY IS SUCCESFUL THEN...

            ThroneResponce = response.body()
        }

        override fun onFailure(call: Call<List<ThroneResponce>>, t: Throwable) {
            Toast.makeText(context, "Api call Failed Terribly", Toast.LENGTH_SHORT).show()
        }

    })

    if (!ThroneResponce.isNullOrEmpty()) {
        LazyColumn {
            items(ThroneResponce!!) { Throne ->
                //  GameOfThronesCharacters(ThroneResponce = Throne)

            }
        }
    } else {
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
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Game Of Thrones Characters")
            })
        }
    ) { paddingValues ->
        val context = LocalContext.current /* --CALLED BEFOR MAKING OR CALLING TOASTS-- */
        var ThroneResponce: List<ThroneResponce>? by remember {
            mutableStateOf<List<ThroneResponce>?>(value = null)
        }

        ThroneInstance.ApiService.getCharacters().enqueue(object : Callback<List<ThroneResponce>> {
            override fun onResponse(
                call: Call<List<ThroneResponce>>,
                response: Response<List<ThroneResponce>>
            ) {
                //IF RESPONCE BODY IS SUCCESFUL THEN...

                ThroneResponce = response.body()
            }

            override fun onFailure(call: Call<List<ThroneResponce>>, t: Throwable) {
                Toast.makeText(context, "Api call Failed Terribly", Toast.LENGTH_SHORT).show()
            }

        })
//        Scaffold(
//            topBar = {
//                TopAppBar(
//                    title = {
//                        Text(text = "Game of Thrones Characters")
//                    },
//                    navigationIcon = {
//                        IconButton(onClick = { /*TODO*/ }) {
//                            Icon(
//                                imageVector = Icons.Filled.ArrowBack ,
//                                contentDescription = null)
//                        }
//                    }
//                )
//            }
//        ) {paddingValues ->
//            Column(
//                modifier = Modifier
//                    .padding(paddingValues)
//            ) {
//                if (!ThroneResponce.isNullOrEmpty()){
//                    LazyColumn(
//                        modifier = Modifier
//                            .padding(paddingValues)
//                    ) {
//                        //nilikwamia apa
//                        items(ThroneResponce!!){ Throne ->
//                            GameOfThronesCharacters(ThroneResponce = Throne)
//                        }
//                    }
//                }else{
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize(),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        CircularProgressIndicator()
//                    }
//
//                }
//            }
//
//        }
//
//    }
//}

        @Composable
        fun CharactersCard(
            ThroneResponce: ThroneResponce,
            onClick: (id: Int) -> Unit
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .height(75.dp)
                    .clickable {
                        onClick(ThroneResponce.id)
                    },
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = ThroneResponce.fullName)

                    AsyncImage(
                        model = ThroneResponce.imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(55.dp)
                            .clip(CircleShape)
                    )
                }
            }
        }
    }
}