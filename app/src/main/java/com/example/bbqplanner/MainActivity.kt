package com.example.bbqplanner

import android.os.Bundle
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

            if (numAdults == 0 || numKids == 0 || bbqDuration <= 0) {

                Snackbar.make(
                    binding.root,
                    "Fullfil all the fields",
                    Snackbar.LENGTH_LONG)
                    .show()

            } else {

                val meatAdults = numAdults * 300 / 1000.0
                val meatKids = numKids * 100 / 1000.0
                val totalMeat = meatAdults + meatKids

                val beerAdult = 3 * bbqDuration
                val totalBeer = numAdults * beerAdult
                val totalSoda = (numKids * 300 * bbqDuration) / 1000.0

                println("marco" + totalMeat)
                println("marco" + totalBeer)
                println("marco" + totalSoda)


            }
        }
    }
}