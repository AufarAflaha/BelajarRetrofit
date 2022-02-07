package com.example.belajarretrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.belajarretrofit.ui.theme.BelajarRetrofitTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : ComponentActivity() {
    var listMedicalRecord by mutableStateOf(listOf<MedicalRecord>())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BelajarRetrofitTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    LazyColumn(){
                       items(listMedicalRecord){
                           data->
                           Greeting(name = data.title)
                       }
                    }

                }
            }
        }
        GetData()
    }
    fun GetData(){
        val apiInterface = ApiInterface.create().getMedicalRecord()
        apiInterface.enqueue(object : Callback<BaseMedicalRecord> {
            override fun onResponse(call: Call<BaseMedicalRecord>, response: Response<BaseMedicalRecord>) {
               val data = response.body()?.data ?: listOf()

                listMedicalRecord = listMedicalRecord + data

            }

            override fun onFailure(call: Call<BaseMedicalRecord>, t: Throwable) {
                Log.e("sasa",t.stackTraceToString())
            }
        })

}
}

@Composable
fun Greeting(name: String) {
    Text(text = "$name!")
}
