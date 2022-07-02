package com.failoc.segundapracticacalificada.Map

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.failoc.segundapracticacalificada.R
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity: AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val actionBar = supportActionBar
        actionBar?.hide()

        createMapFragment()
    }

    private fun createMapFragment(){

        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragmentMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap){

        try {

            val success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    this, R.raw.stylemap
                ))

            if(success) {
                Log.v("GOOGLE_MAPS", "CORRECTO")
            } else {

                Log.v("GOOGLE_MAPS", "INCORRECTO")

            }
        }catch (e: Resources.NotFoundException){
            Log.v("GOOGLE_MAPS", "ERROR : ", e)
        }

        //Marcador

        val posicionMarkerDMarco = LatLng(-8.123310,-79.037583)

        googleMap.addMarker(
            MarkerOptions().position(posicionMarkerDMarco).title("D'Marco Café")
        )
        googleMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(posicionMarkerDMarco, 13F),4000, null
        )

        googleMap.uiSettings.isZoomControlsEnabled = true
        googleMap.uiSettings.isRotateGesturesEnabled = false
    }
}