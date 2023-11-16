package com.nguyenhoangthanhan.tictactoeapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.nguyenhoangthanhan.tictactoeapp.R
import com.nguyenhoangthanhan.tictactoeapp.databinding.ActivityChooseYourSideBinding
import com.nguyenhoangthanhan.tictactoeapp.databinding.ActivityMainBinding
import com.nguyenhoangthanhan.tictactoeapp.utils.AppConstants

class ChooseYourSideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseYourSideBinding

    private var username: String? = null
    private var friendName: String? = null
    private var yourSide: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseYourSideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        username = intent?.getStringExtra(AppConstants.USERNAME) ?: ""
        friendName = intent?.getStringExtra(AppConstants.FRIEND_NAME) ?: ""

        initViews()
        initEvents()
    }

    private fun initViews() {
        username?.let {
            binding.tvGreetUser.text = getString(R.string.hello_user, it)
        }
    }

    private fun initEvents() {
        binding.imgCloseChooseYourSideScreen.setOnClickListener {
            finish()
        }

        binding.rgSidesContainer.setOnCheckedChangeListener { radioGroup, i ->
            binding.tvYourSelectedSide.visibility = View.VISIBLE
            if (i == R.id.rb_heart) {
                sideSelected(AppConstants.TEAM_HEART)
            } else if (i == R.id.rb_star) {
                sideSelected(AppConstants.TEAM_STAR)
            }
        }

        binding.btnNextAfterChooseYourSide.setOnClickListener {
            if (yourSide.isNullOrEmpty()) {
                Toast.makeText(this, getString(R.string.choose_a_side), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, getString(R.string.all_set), Toast.LENGTH_SHORT).show()
                goToGameActivity()
            }
        }
    }

    private fun sideSelected(selectedSideValue: String) {
        yourSide = selectedSideValue
        binding.tvYourSelectedSide.text = getString(R.string.you_choose, yourSide)

        binding.btnNextAfterChooseYourSide.apply {
            background = getDrawable(R.drawable.ic_filled_rectangle_shape_purple_700)
            text = getString(R.string.play)
            setTextColor(getColor(R.color.white))
        }
    }

    private fun goToGameActivity() {
        startActivity(Intent(this, GameActivity::class.java).also {
            it.putExtra(AppConstants.USERNAME, username)
            it.putExtra(AppConstants.FRIEND_NAME, friendName)
            it.putExtra(AppConstants.SELECTED_SIDE, yourSide)
        })
    }
}