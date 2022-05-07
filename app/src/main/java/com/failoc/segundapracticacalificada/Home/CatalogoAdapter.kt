package com.failoc.segundapracticacalificada.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CatalogoAdapter(val list: List<Catalogo>): RecyclerView.Adapter<CatalogoViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CatalogoViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CatalogoViewHolder, position: Int) {
        val catalogo = list[position]
        holder.bind(catalogo)
    }




}