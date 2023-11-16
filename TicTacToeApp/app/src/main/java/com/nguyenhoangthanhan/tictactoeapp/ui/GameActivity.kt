package com.nguyenhoangthanhan.tictactoeapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguyenhoangthanhan.tictactoeapp.R
import com.nguyenhoangthanhan.tictactoeapp.databinding.ActivityGameBinding
import com.nguyenhoangthanhan.tictactoeapp.databinding.ActivityMainBinding
import com.nguyenhoangthanhan.tictactoeapp.utils.AppConstants

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding

    private var username: String = ""
    private var userSide: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initEvents()
    }

    private fun initViews() {
        username = intent?.getStringExtra(AppConstants.USERNAME) ?: ""
        userSide = intent?.getStringExtra(AppConstants.SELECTED_SIDE) ?: ""

        binding.tvNameOfUser.text = username
    }

    private fun initEvents() {
        binding.imgCloseGameScreen.setOnClickListener {
            finish()
        }
    }
}