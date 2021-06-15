package br.iesb.mobile.gentil

import android.graphics.Color
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import br.iesb.mobile.gentil.model.Anuncio
import kotlinx.android.synthetic.main.anuncios_list.view.*

class AnuncioAdapter(val anuncios: MutableList<Anuncio>) : RecyclerView.Adapter<AnuncioAdapter.AnuncioViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnuncioViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.anuncios_list, parent, false)
        return AnuncioViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnuncioViewHolder, position: Int) {
        holder.bind(anuncios[position])
    }

    override fun getItemCount(): Int = anuncios.size

    inner class AnuncioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(anuncio: Anuncio) {
            with(anuncio){
                val hash = title.hashCode()
                itemView.tv_txt_icon.text = title.first().toString()
                itemView.tv_txt_icon.background = itemView.oval(Color.rgb(hash, hash/2, 0))
                itemView.tv_txt_title.text = title
                itemView.tv_txt_preview.text = preview
                itemView.tv_txt_date.text = date
            }
        }

    }
}

fun View.oval(@ColorInt color: Int): ShapeDrawable {
    val oval = ShapeDrawable(OvalShape())
    with(oval){
        intrinsicHeight = height
        intrinsicWidth = width
        paint.color = color
    }
    return oval
}