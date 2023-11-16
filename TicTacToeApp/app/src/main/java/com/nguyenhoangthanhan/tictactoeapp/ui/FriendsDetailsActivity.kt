package com.nguyenhoangthanhan.tictactoeapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nguyenhoangthanhan.tictactoeapp.R
import com.nguyenhoangthanhan.tictactoeapp.databinding.ActivityFriendsDtailsBinding
import com.nguyenhoangthanhan.tictactoeapp.databinding.ActivityMainBinding
import com.nguyenhoangthanhan.tictactoeapp.utils.AppConstants
import com.nguyenhoangthanhan.tictactoeapp.utils.Utility

class FriendsDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFriendsDtailsBinding

    private var username:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFriendsDtailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        username = intent?.getStringExtra(AppConstants.USERNAME) ?: ""

        initEvents()
    }

    private fun initEvents() {
        binding.imgCloseFriendsDetailsScreen.setOnClickListener {
            finish()
        }
        binding.btnNextAfterFriendDetails.setOnClickListener {
            redirectToChooseYourSideActivity()
        }
    }

    private fun redirectToChooseYourSideActivity() {
        val friendName = binding.edtFriendName.text.toString()
        if (friendName.isEmpty()) {
            binding.edtFriendName.error = getString(R.string.please_enter_valid_name)
            Toast.makeText(this, getString(R.string.please_enter_valid_name), Toast.LENGTH_SHORT)
                .show()
        } else {
            Utility.hideKeyboard(this@FriendsDetailsActivity)
            startActivity(
                Intent(
                    this@FriendsDetailsActivity,
                    ChooseYourSideActivity::class.java
                ).apply {
                    putExtra(AppConstants.USERNAME, username)
                    putExtra(AppConstants.FRIEND_NAME, friendName)
                })
        }
    }
}