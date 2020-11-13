package com.desafio.digitalhousefoods.Prato

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.desafio.digitalhousefoods.R
import kotlinx.android.synthetic.main.item_cardapio_menu.view.*

class PratosAdapter(private val listaPratos: List<Pratos>, val listener: OnClickPratosListener):
    RecyclerView.Adapter<PratosAdapter.CardPratos>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardPratos {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_cardapio_menu, parent, false)
        return CardPratos(itemView)
    }

    override fun onBindViewHolder(holder: CardPratos, position: Int) {
        val currentItem = listaPratos[position]

        holder.nomePrato.text = currentItem.nomePrato
        holder.imgPrato.setImageResource(currentItem.img)

    }

    override fun getItemCount() = listaPratos.size

    interface OnClickPratosListener{
        fun OnClickPratos(position: Int)
    }

    inner class CardPratos(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val nomePrato: TextView = itemView.tv_nome_prato
        val imgPrato: ImageView = itemView.img_restaurante_prato

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION)
                listener.OnClickPratos(position)
        }
    }
}