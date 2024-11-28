package com.example.bbqplanner

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bbqplanner.databinding.ActivityResultBinding

const val KEY_ADULT_MEAT = "ResultActivity.KEY_ADULT_MEAT"
const val KEY_TOTAL_BEER = "ResultActivity.KEY_TOTAL_BEER"
const val KEY_TOTAL_SODA = "ResultActivity.KEY_TOTAL_SODA"

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityResultBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val meatResult = intent.getDoubleExtra(KEY_ADULT_MEAT,0.0)
        val beerResult = intent.getFloatExtra(KEY_TOTAL_BEER,0f)
        val sodaResult = intent.getDoubleExtra(KEY_TOTAL_SODA,0.0)

        Log.d("BeerDebug", "beerResult received in ResultActivity: $beerResult")

        if (beerResult == 0f) {
            Log.d("BeerDebug", "Warning: beerResult is 0, check the Intent passing logic")
        }

        binding.meatResult.text = "Total of meat (Kg): " + meatResult
        binding.beerResult.text = "Total of beer (cans): " + beerResult.toInt()
        binding.sodaResult.text = "Total of soda (bottles): " + sodaResult.toInt()

        binding.btnRefresh.setOnClickListener(){

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        }
    }