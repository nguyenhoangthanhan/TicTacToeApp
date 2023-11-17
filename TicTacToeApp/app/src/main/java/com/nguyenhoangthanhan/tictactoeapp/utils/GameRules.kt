package com.nguyenhoangthanhan.tictactoeapp.utils

object GameRules {

    //All winning positions
    val winningPos = arrayOf(
        intArrayOf(1, 2 , 3),
        intArrayOf(4, 5 , 6),
        intArrayOf(7, 8 , 9),
        intArrayOf(1, 4 , 7),
        intArrayOf(2, 5 , 8),
        intArrayOf(3, 6 , 9),
        intArrayOf(1, 5 , 9),
        intArrayOf(3, 5 , 7),
    )

    fun checkForWin(filledPositions: IntArray): Boolean {
        var isWinner: Boolean
        isWinner = false

        winningPos.forEachIndexed { index, ints ->
            val value1 = winningPos[index][0]
            val value2 = winningPos[index][1]
            val value3 = winningPos[index][2]

            if (filledPositions[value1 - 1] == filledPositions[value2 - 1]
                && filledPositions[value3 - 1] == filledPositions[value2 - 1]){
                if (filledPositions[value1 - 1] != -1){
                    isWinner = true
                }
            }
        }
        return isWinner
    }
}