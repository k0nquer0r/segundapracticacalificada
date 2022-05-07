package com.failoc.segundapracticacalificada.Home


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.failoc.segundapracticacalificada.R
import kotlinx.android.synthetic.main.fragment_catalogo.*

class HomeActivity: AppCompatActivity() {

    private val listCatalogo = listOf(
        Catalogo("Pizza D'MARCO", "Pizzas", "S/ 25.00", "La mejor pizza con la combinación perfecta de queso, espinaca y carnes del norte trujillano",R.drawable.imagen1),
        Catalogo("Duo DMARCO", "Bebidas", "S/ 15.00", "La combinación perfecta para compartir entre amigos",R.drawable.imagen2),
        Catalogo("Cafe", "Bebidas", "S/ 10.00", "Los mejores granos del norte peruano solo en DMARCO",R.drawable.imagen3),
        Catalogo("Pan con Pollo", "Sanguches", "S/ 15.00", "El tradicional pan con pollo trujillano, solo en DMARCO",R.drawable.imagen4),
        Catalogo("Ceviche", "Entrada", "S/ 15.00", "El mejor ceviche trujillano, solo en DMARCO",R.drawable.imagen5),
        )

    companion object{
        fun newInstance(): HomeActivity = HomeActivity()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_catalogo)
        val actionBar = supportActionBar
        actionBar?.hide()

        recyclerCatalogo.apply {
            //layoutManager = GridLayoutManager(activity, 2)
            //layoutManager = LinearLayoutManager(context)
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            adapter = CatalogoAdapter(listCatalogo)
        }
    }

}