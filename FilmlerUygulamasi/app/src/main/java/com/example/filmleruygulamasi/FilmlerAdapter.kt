package com.example.filmleruygulamasi

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

data class FilmlerAdapter(private val mContext:Context,private val filmlerListe:List<Filmler>)
    : RecyclerView.Adapter<FilmlerAdapter.filmTasarimTutucu>() {

    inner class filmTasarimTutucu(tasarim:View):RecyclerView.ViewHolder(tasarim){
        var film_card: CardView
        var textViewFilmAd: TextView
        var imageViewFilmResim:ImageView

        init {
            film_card = tasarim.findViewById(R.id.film_card)
            textViewFilmAd = tasarim.findViewById(R.id.textViewFilmAd)
            imageViewFilmResim = tasarim.findViewById(R.id.imageViewFilmResim)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): filmTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.film_card_tasarim,parent,false)
        return filmTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return filmlerListe.size
    }

    override fun onBindViewHolder(holder: filmTasarimTutucu, position: Int) {
        val film = filmlerListe[position]
        holder.textViewFilmAd.text = film.film_ad
        holder.imageViewFilmResim.setImageResource(mContext.resources.getIdentifier(film.film_resim
            ,"drawable",mContext.packageName))

        holder.film_card.setOnClickListener {
            val intent = Intent(mContext,DetayActivity::class.java)
            intent.putExtra("filmNesne",film)
            mContext.startActivity(intent)
        }

    }
}