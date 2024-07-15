package com.zul.superheroapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.zul.superheroapp.databinding.ActivityMainBinding
import com.zul.superheroapp.model.Superhero
import com.zul.superheroapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchSuperheroData()
    }

    private fun fetchSuperheroData() {
        RetrofitClient.instance.getSuperhero().enqueue(object : Callback<Superhero> {
            override fun onResponse(call: Call<Superhero>, response: Response<Superhero>) {
                val superhero = response.body()
                if (superhero != null) {
                    displaySuperhero(superhero)
                }
            }

            override fun onFailure(call: Call<Superhero>, t: Throwable) {
            }
        })
    }

    private fun displaySuperhero(superhero: Superhero) {
        binding.tvName.text = superhero.name
        binding.tvFullName.text = "Full Name: ${superhero.biography.`full-name`}"
        binding.tvPowerstats.text = """
            Intelligence: ${superhero.powerstats.intelligence}
            Strength: ${superhero.powerstats.strength}
            Speed: ${superhero.powerstats.speed}
            Durability: ${superhero.powerstats.durability}
            Power: ${superhero.powerstats.power}
            Combat: ${superhero.powerstats.combat}
        """.trimIndent()
        binding.tvBiography.text = """
            Place of Birth: ${superhero.biography.`place-of-birth`}
            First Appearance: ${superhero.biography.`first-appearance`}
            Publisher: ${superhero.biography.publisher}
            Alignment: ${superhero.biography.alignment}
        """.trimIndent()


        Glide.with(this)
            .load(superhero.image.url)
            .into(binding.ivImage)
    }
}
// Nama : Muhammad Sheva Zulfiqar Arrizqi
//Kelas : AKB-UL1
//NIM : 10120748

