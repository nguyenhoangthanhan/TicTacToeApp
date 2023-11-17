package com.nguyenhoangthanhan.tictactoeapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguyenhoangthanhan.tictactoeapp.R
import com.nguyenhoangthanhan.tictactoeapp.databinding.ActivityMainBinding
import com.nguyenhoangthanhan.tictactoeapp.databinding.ActivityResultBinding
import com.nguyenhoangthanhan.tictactoeapp.utils.AppConstants

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    private var winner: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initEvents()
    }

    private fun initViews() {
        winner = intent?.getStringExtra(AppConstants.WINNER_MESSAGE) ?: ""
        val teamWin = intent?.getIntExtra(AppConstants.WINNER_TEAM, 0)

        binding.tvWinner.text = winner

        if (teamWin == 0) {
            binding.imgWinnerTeam.setImageResource(R.drawable.ic_heart)
            binding.tvWinnerTeam.text = getString(R.string.team_heart)
        } else {
            binding.imgWinnerTeam.setImageResource(R.drawable.ic_star)
            binding.tvWinnerTeam.text = getString(R.string.team_star)
        }
    }

    private fun initEvents() {
        binding.btnPlayAgain.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            })
        }
    }
}