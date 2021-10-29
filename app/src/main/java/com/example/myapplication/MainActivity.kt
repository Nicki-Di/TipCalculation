package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDouble()
        val tipPercentage : Double
        when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> {
                tipPercentage = 0.20
                binding.root.setBackgroundColor(Color.parseColor("#67f754"))
            }
            R.id.option_eighteen_percent -> {
                tipPercentage = 0.18
                binding.root.setBackgroundColor(Color.parseColor("#e9f754"))
            }
            else -> {
                tipPercentage = 0.15
                binding.root.setBackgroundColor(Color.parseColor("#f75f54"))
            }
        }
        var tip = tipPercentage * cost
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        binding.tipResult.text = "مقدار انعام: $tip تومان "
    }
}