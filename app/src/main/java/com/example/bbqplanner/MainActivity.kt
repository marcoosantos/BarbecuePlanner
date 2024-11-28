package com.example.bbqplanner

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bbqplanner.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {

            val numAdults = binding.tieNumAdults.text.toString().toIntOrNull() ?: 0
            val numKids = binding.tieNumKids.text.toString().toIntOrNull() ?: 0
            val bbqDuration = binding.tieBbqduration.text.toString().toFloatOrNull() ?: 0f

            Log.d("BeerDebug", "numAdults: $numAdults")
            Log.d("BeerDebug", "numKids: $numKids")
            Log.d("BeerDebug", "bbqDuration: $bbqDuration")

            if (numAdults <= 0 || numKids <= 0 || bbqDuration <= 0) {

                Snackbar.make(
                    binding.root,
                    "Please fill in all the fields correctly",
                    Snackbar.LENGTH_LONG
                )
                    .show()

            } else {

                val meatAdults = numAdults * 300 / 1000.0
                val meatKids = numKids * 100 / 1000.0
                val totalMeat = meatAdults + meatKids

                val beerAdult = 3 * bbqDuration
                val totalBeer = (numAdults * beerAdult)
                val totalSoda = (numKids * 300 * bbqDuration) / 1000.0

                Log.d("BeerDebug", "beerAdult: $beerAdult")
                Log.d("BeerDebug", "totalBeer (numAdults * beerAdult): $totalBeer")

                Log.d("BeerDebug", "Sending totalBeer (totalBeer): $totalBeer")

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_ADULT_MEAT, totalMeat)
                intent.putExtra(KEY_TOTAL_BEER, totalBeer.toFloat())
                intent.putExtra(KEY_TOTAL_SODA, totalSoda)

                startActivity(intent)


            }
        }
    }
}