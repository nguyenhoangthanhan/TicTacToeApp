package com.nguyenhoangthanhan.tictactoeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguyenhoangthanhan.tictactoeapp.databinding.ActivityChooseYourSideBinding
import com.nguyenhoangthanhan.tictactoeapp.databinding.ActivityMainBinding

class ChooseYourSideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseYourSideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseYourSideBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}