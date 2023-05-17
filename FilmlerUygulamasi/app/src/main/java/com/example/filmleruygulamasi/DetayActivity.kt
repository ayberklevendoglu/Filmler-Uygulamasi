package com.example.filmleruygulamasi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filmleruygulamasi.databinding.ActivityDetayBinding

class DetayActivity : AppCompatActivity() {
    private lateinit var tasarim:ActivityDetayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        val film = intent.getSerializableExtra("filmNesne") as Filmler
        tasarim.textViewDetayAd.text = film.film_ad
        tasarim.textViewFilmYil.text = film.film_yil.toString()
        tasarim.textViewYonetmen.text = film.yonetmen.yonetmen_ad
        tasarim.imageViewDetay.setImageResource(this.resources.getIdentifier(film.film_resim
            ,"drawable",this.packageName))

    }
}