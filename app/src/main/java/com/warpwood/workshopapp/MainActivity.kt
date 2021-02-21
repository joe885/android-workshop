package com.warpwood.workshopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.warpwood.workshopapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.label.text = "My first Android app"
    }
}