package com.example.filmleruygulamasi

import java.io.Serializable

data class Filmler(var film_id:Int,var film_ad:String,var film_yil:Int,var film_resim:String,
                   var yonetmen:Yonetmenler,var kategori:Kategoriler):Serializable {
}