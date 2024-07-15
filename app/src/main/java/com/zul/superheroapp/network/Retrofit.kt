package com.zul.superheroapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://www.superheroapi.com/"

    val instance: SuperheroApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(SuperheroApiService::class.java)
    }
}
// Nama : Muhammad Sheva Zulfiqar Arrizqi
//Kelas : AKB-UL1
//NIM : 10120748