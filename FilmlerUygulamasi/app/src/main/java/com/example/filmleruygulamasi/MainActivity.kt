package com.example.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmleruygulamasi.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlin.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var kategoriListe:ArrayList<Kategoriler>
    private lateinit var adapter:KategoriAdapter
    private lateinit var vt:VeritabaniYardimcisi

    private lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)
        veritabaniKopyala()

        tasarim.toolbarKategori.title = "Kategoriler"
        setSupportActionBar(tasarim.toolbarKategori)

        tasarim.kategoriRv.setHasFixedSize(true)
        tasarim.kategoriRv.layoutManager = LinearLayoutManager(this)

        vt = VeritabaniYardimcisi(this)
        kategoriListe = Kategorilerdao().tumKategoriler(vt)

        adapter = KategoriAdapter(this,kategoriListe)
        tasarim.kategoriRv.adapter = adapter
    }

    fun veritabaniKopyala(){
        val copyHelper = DatabaseCopyHelper(this)
        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}