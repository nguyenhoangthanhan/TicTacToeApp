package com.nguyenhoangthanhan.tictactoeapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nguyenhoangthanhan.tictactoeapp.R
import com.nguyenhoangthanhan.tictactoeapp.databinding.ActivityPlayerDetailsBinding
import com.nguyenhoangthanhan.tictactoeapp.utils.AppConstants
import com.nguyenhoangthanhan.tictactoeapp.utils.Utility

class PlayerDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayerDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initEvents()
    }

    private fun initEvents() {
        binding.imgClosePlayDetailsScreen.setOnClickListener {
            finish()
        }
        binding.btnNextAfterPlayDetails.setOnClickListener {
            redirectToChooseYourSideActivity()
        }
    }

    private fun redirectToChooseYourSideActivity() {
        var username = binding.edtUsername.text.toString()
        if (username.isEmpty()) {
            binding.edtUsername.error = getString(R.string.please_enter_valid_name)
            Toast.makeText(this, getString(R.string.please_enter_valid_name), Toast.LENGTH_SHORT)
                .show()
        } else {
            Utility.hideKeyboard(this@PlayerDetailsActivity)
            startActivity(
                Intent(
                    this@PlayerDetailsActivity,
                    FriendsDetailsActivity::class.java
                ).apply {
                    putExtra(AppConstants.USERNAME, username)
                })
        }
    }
}