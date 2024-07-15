package com.zul.superheroapp.network

import com.zul.superheroapp.model.Superhero
import retrofit2.Call
import retrofit2.http.GET

interface SuperheroApiService {
    @GET("api.php/da3768bdf1ee8210c0b003c2823457db/414")
    fun getSuperhero(): Call<Superhero>
}
// Nama : Muhammad Sheva Zulfiqar Arrizqi
//Kelas : AKB-UL1
//NIM : 10120748