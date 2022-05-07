package com.failoc.segundapracticacalificada.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.failoc.segundapracticacalificada.R

class CatalogoViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_catalogo, parent, false)) {

    private var imgCatalogo: ImageView? = null
    private var texttitle: TextView? = null
    private var texttype: TextView? = null
    private var textprice: TextView? = null
    private var textdescription: TextView? = null

    init {
        imgCatalogo = itemView.findViewById(R.id.imgCatalogo)
        texttitle = itemView.findViewById(R.id.texttitle)
        texttype = itemView.findViewById(R.id.texttype)
        textprice = itemView.findViewById(R.id.textprice)
        textdescription = itemView.findViewById(R.id.textdescription)
    }

    fun bind(catalogo: Catalogo){
        texttitle?.text = catalogo.title
        texttype?.text = catalogo.type
        textprice?.text = catalogo.price
        textdescription?.text = catalogo.description
        imgCatalogo?.setImageResource(catalogo.image)
    }
}