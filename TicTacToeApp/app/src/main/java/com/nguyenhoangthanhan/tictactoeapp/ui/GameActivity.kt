package com.nguyenhoangthanhan.tictactoeapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.nguyenhoangthanhan.tictactoeapp.R
import com.nguyenhoangthanhan.tictactoeapp.databinding.ActivityGameBinding
import com.nguyenhoangthanhan.tictactoeapp.utils.AppConstants
import com.nguyenhoangthanhan.tictactoeapp.utils.GameRules

class GameActivity : AppCompatActivity() {

    private val TAG = "GameActivity_TAG"

    private lateinit var binding: ActivityGameBinding

    private var username: String = ""
    private var friendName: String? = null
    private var userSide: String = ""

    private var playWithFriend: Boolean = false
    private var filledPositions = intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1)
    private var isGameInProgress: Boolean = true
    private var activeUser: Int = 0
    private var statusUser = Pair(-1, "USER")

    private var player0 = 0
    private var player1 = 1

    private var userSteps: Int = 0
    private var friendOrRobotStep: Int = 0

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
            binding.viewActiveUser.visibility = View.VISIBLE
            binding.viewActiveFriendOrRobot.visibility = View.INVISIBLE

            if (this == AppConstants.TEAM_HEART) {
                activeUser = 0
                statusUser = Pair(0, "USER")
            } else if (this == AppConstants.TEAM_STAR) {
                activeUser = 1
                statusUser = Pair(1, "USER")
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
            val pos = it?.tag.toString().toInt()
            Log.d(TAG, "Position: $pos")
            playClick(pos, it as ImageView)
        }

        binding.imgSecond.setOnClickListener {
            val pos = it?.tag.toString().toInt()
            Log.d(TAG, "Position: $pos")
            playClick(pos, it as ImageView)
        }

        binding.imgThird.setOnClickListener {
            val pos = it?.tag.toString().toInt()
            Log.d(TAG, "Position: $pos")
            playClick(pos, it as ImageView)
        }

        binding.imgFourth.setOnClickListener {
            val pos = it?.tag.toString().toInt()
            Log.d(TAG, "Position: $pos")
            playClick(pos, it as ImageView)
        }

        binding.imgFifth.setOnClickListener {
            val pos = it?.tag.toString().toInt()
            Log.d(TAG, "Position: $pos")
            playClick(pos, it as ImageView)
        }

        binding.imgSixth.setOnClickListener {
            val pos = it?.tag.toString().toInt()
            Log.d(TAG, "Position: $pos")
            playClick(pos, it as ImageView)
        }

        binding.imgSeventh.setOnClickListener {
            val pos = it?.tag.toString().toInt()
            Log.d(TAG, "Position: $pos")
            playClick(pos, it as ImageView)
        }

        binding.imgEighth.setOnClickListener {
            val pos = it?.tag.toString().toInt()
            Log.d(TAG, "Position: $pos")
            playClick(pos, it as ImageView)
        }

        binding.imgNinth.setOnClickListener {
            val pos = it?.tag.toString().toInt()
            Log.d(TAG, "Position: $pos")
            playClick(pos, it as ImageView)
        }
    }

    private fun playClick(pos: Int, view: ImageView) {
        if (!isGameInProgress) return
        if (activeUser == player0 && filledPositions[pos - 1] == -1) {
            filledPositions[pos - 1] = player0
            activeUser = player1
            userSteps += 1
            binding.tvUserSteps.text = userSteps.toString()
            view.setImageResource(R.drawable.ic_heart)
            if (GameRules.checkForWin(filledPositions)) {
                gameCompleted(player0)
            }
        } else if (activeUser == player1 && filledPositions[pos - 1] == -1) {
            filledPositions[pos - 1] = player1
            activeUser = player0
            friendOrRobotStep += 1
            binding.tvFriendOrAISteps.text = friendOrRobotStep.toString()
            view.setImageResource(R.drawable.ic_star)
            if (GameRules.checkForWin(filledPositions)) {
                gameCompleted(player1)
            }
        }

        if (activeUser == statusUser.first) {
            binding.viewActiveUser.visibility = View.VISIBLE
            binding.viewActiveFriendOrRobot.visibility = View.INVISIBLE
        } else {
            binding.viewActiveUser.visibility = View.INVISIBLE
            binding.viewActiveFriendOrRobot.visibility = View.VISIBLE
        }
    }

    private fun gameCompleted(winner: Int) {
        Log.d(TAG, "Winner: $winner")
        val teamWin = if (winner == 0) 0 else 1

        if (winner == statusUser.first) {
            isGameInProgress = false
            binding.tvWinner.text = getString(R.string.template_won_game, username)
            startActivity(Intent(this@GameActivity, ResultActivity::class.java).also {
                it.putExtra(
                    AppConstants.WINNER_MESSAGE,
                    getString(R.string.template_won_game, username)
                )
                it.putExtra(
                    AppConstants.WINNER_TEAM,
                    teamWin
                )
            })
        } else {
            isGameInProgress = false
            binding.tvWinner.text = getString(R.string.template_won_game, friendName)
            startActivity(Intent(this@GameActivity, ResultActivity::class.java).also {
                it.putExtra(
                    AppConstants.WINNER_MESSAGE,
                    getString(R.string.template_won_game, friendName)
                )
                it.putExtra(
                    AppConstants.WINNER_TEAM,
                    teamWin
                )
            })
        }
    }
}