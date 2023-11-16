package com.nguyenhoangthanhan.tictactoeapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nguyenhoangthanhan.tictactoeapp.R
import com.nguyenhoangthanhan.tictactoeapp.databinding.ActivityGameBinding
import com.nguyenhoangthanhan.tictactoeapp.databinding.ActivityMainBinding
import com.nguyenhoangthanhan.tictactoeapp.utils.AppConstants

class GameActivity : AppCompatActivity() {

    private val TAG = "GameActivity_TAG"

    private lateinit var binding: ActivityGameBinding

    private var username: String = ""
    private var friendName: String? = null
    private var userSide: String = ""

    private var playWithFriend: Boolean = false
    private var filledPositions = intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1)
    private var isGameInProgress: Boolean = false
    private var activeUser: Int = 0

    private var player0 = 0
    private var player1 = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initEvents()
    }

    private fun initViews() {
        username = intent?.getStringExtra(AppConstants.USERNAME) ?: ""
        friendName = intent?.getStringExtra(AppConstants.FRIEND_NAME) ?: ""
        userSide = intent?.getStringExtra(AppConstants.SELECTED_SIDE) ?: ""

        userSide.apply {
            if (this == AppConstants.TEAM_HEART) {
                activeUser = 0
            } else if (this == AppConstants.TEAM_STAR) {
                activeUser = 1
            }
        }

        binding.tvNameOfUser.text = username
        if (!friendName?.trim().isNullOrEmpty()) {
            playWithFriend = true
            binding.imgFriendsOrAI.setImageResource(R.drawable.friend)
            binding.tvNameOfRobotOrFriend.text = friendName
        } else {
            binding.imgFriendsOrAI.setImageResource(R.drawable.robot)
            binding.tvNameOfRobotOrFriend.text = getString(R.string.robot)
        }
    }

    private fun initEvents() {
        binding.imgCloseGameScreen.setOnClickListener {
            finish()
        }

        binding.imgFirst.setOnClickListener {
            Log.d(TAG, "Position: " + it?.tag.toString().toInt().toString())
        }

        binding.imgSecond.setOnClickListener {
            Log.d(TAG, "Position: " + it?.tag.toString().toInt().toString())
        }

        binding.imgThird.setOnClickListener {
            Log.d(TAG, "Position: " + it?.tag.toString().toInt().toString())
        }

        binding.imgFourth.setOnClickListener {
            Log.d(TAG, "Position: " + it?.tag.toString().toInt().toString())
        }

        binding.imgFifth.setOnClickListener {
            Log.d(TAG, "Position: " + it?.tag.toString().toInt().toString())
        }

        binding.imgSixth.setOnClickListener {
            Log.d(TAG, "Position: " + it?.tag.toString().toInt().toString())
        }

        binding.imgSeventh.setOnClickListener {
            Log.d(TAG, "Position: " + it?.tag.toString().toInt().toString())
        }

        binding.imgEighth.setOnClickListener {
            Log.d(TAG, "Position: " + it?.tag.toString().toInt().toString())
        }

        binding.imgNinth.setOnClickListener {
            Log.d(TAG, "Position: " + it?.tag.toString().toInt().toString())
        }
    }
}