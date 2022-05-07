package com.failoc.segundapracticacalificada.Login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.failoc.segundapracticacalificada.Home.HomeActivity
import com.failoc.segundapracticacalificada.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.v("CICLO_VIDA", "onCreate")

        val actionBar = supportActionBar
        actionBar?.hide()

        btnIngresar.setOnClickListener {

            val correo = edtcorreo.text.toString()
            val clave = edtpass.text.toString()
            //activador
            //startActivity(Intent(this, HomeActivity::class.java))
            //finish()

            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("email", correo)
            //intent.putExtra("name", "Frank Ventura")

            startActivity(intent)

            finish()



        }


    }

    override fun onStart() {
        super.onStart()
        Log.v("CICLO_VIDA", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("CICLO_VIDA", "onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.v("CICLO_VIDA", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("CICLO_VIDA", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("CICLO_VIDA", "onDestroy")
    }

    //Desarrollado por @Frank-Ventura
}