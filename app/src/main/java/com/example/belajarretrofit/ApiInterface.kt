package com.example.belajarretrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import com.google.gson.GsonBuilder

import com.google.gson.Gson
import retrofit2.http.Header
import retrofit2.http.Headers


interface ApiInterface {

    @GET("api/medical-records/CXPq9AD0XZoOO")
    @Headers(
        "x-api-key:MTYzNTEzMDIzNDY0MA==16351302346401637558061370"
    )
    fun getMedicalRecord() : Call<BaseMedicalRecord>

    companion object {

        var BASE_URL = "https://devdevice.cexup.com/"

        fun create() : ApiInterface {
            val gson = GsonBuilder()
                .setLenient()
                .create()
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}