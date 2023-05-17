package com.example.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmleruygulamasi.databinding.ActivityFilmlerBinding

class FilmlerActivity : AppCompatActivity() {
    private lateinit var filmListe:ArrayList<Filmler>
    private lateinit var adapter:FilmlerAdapter
    private lateinit var vt:VeritabaniYardimcisi

    private lateinit var tasarim:ActivityFilmlerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityFilmlerBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        val kategori = intent.getSerializableExtra("kategoriNesne") as Kategoriler

        tasarim.toolbarFilmler.title = "Filmler : ${kategori.kategori_ad}"
        setSupportActionBar(tasarim.toolbarFilmler)

        tasarim.filmlerRv.setHasFixedSize(true)
        tasarim.filmlerRv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        vt = VeritabaniYardimcisi(this)

        filmListe = Filmlerdao().tumFilmlerbyKategoriId(vt,kategori.kategori_id)

        adapter = FilmlerAdapter(this,filmListe)
        tasarim.filmlerRv.adapter = adapter
    }
}