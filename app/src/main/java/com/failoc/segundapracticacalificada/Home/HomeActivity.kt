package com.failoc.segundapracticacalificada.Home


import android.content.Intent
import android.os.Bundle
import android.util.Log


import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.failoc.segundapracticacalificada.Map.MapActivity
import com.failoc.segundapracticacalificada.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import kotlinx.android.synthetic.main.fragment_catalogo.*

class HomeActivity: AppCompatActivity() {

    lateinit var adViewBanner : AdView

    var mInterstitialAd : InterstitialAd? = null

    var mRewardedAd: RewardedAd? = null

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

        MobileAds.initialize(this)

        //ANUNCIO BANNER

        adViewBanner = findViewById(R.id.adViewBanner)
        val adRequest = AdRequest.Builder().build()
        adViewBanner.loadAd(adRequest)

        //ANUNCIO INTERSTICIAL

        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712",
            adRequest, object : InterstitialAdLoadCallback(){

                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.v("ASD_ADMOB", "Intersticial-error")
                    Log.v("ASD_ADMOB", adError.message)
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.v("ASD_ADMOB", "Intersticial-correcto")
                    mInterstitialAd = interstitialAd

                }


            })

        btnIntersticial.setOnClickListener{
            if (mInterstitialAd != null){
                mInterstitialAd?.show(this)
            }else{
                Log.v("ASD_ADMOB", "Intersticial-No inicia")
            }
        }

        //ANUNCIO BONIFICADO

        RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917",
            adRequest, object : RewardedAdLoadCallback(){
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    mRewardedAd = null
                }

                override fun onAdLoaded(rewardedAd: RewardedAd) {
                    mRewardedAd = rewardedAd
                }
            })

        btnBonificado.setOnClickListener{
            if (mRewardedAd != null){
                mRewardedAd?.show(this){
                    fun onUserEarnedReward(rewardItem: RewardItem){
                        var rewardAmount = rewardItem.amount
                        var rewardType = rewardItem.type
                        Log.v("ADS_BONIFICADO", rewardAmount.toString())
                        Log.v("ADS_BONIFICADO", rewardType)
                    }
                    onUserEarnedReward(it)
                }
            }else{
                Log.v("ADS_BONIFICADO", "ERROR")
            }
        }


        //CARGANDO FRAGMENTO
        recyclerCatalogo.apply {
            //layoutManager = GridLayoutManager(activity, 2)
            //layoutManager = LinearLayoutManager(context)
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            adapter = CatalogoAdapter(listCatalogo)
        }

        btnUbicacion.setOnClickListener{
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)

            finish()
        }


    }



}