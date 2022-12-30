package com.adriantache.bowlingscoring.domain.model

import com.adriantache.bowlingscoring.domain.model.Score.Companion.isGameOver
import com.adriantache.bowlingscoring.domain.model.Score.Companion.sum
import com.adriantache.bowlingscoring.domain.util.extension.replace

data class Player(
    val name: String,
    val scores: List<Score> = Score.getFrames(),
) {
    val totalScore = scores.sum()

    val isGameOver = scores.isGameOver()

    fun addScore(score: Int): Player {
        require(score in 0..10)
        require(!isGameOver)

        val index = scores.indexOfFirst { !it.isComplete }
        val newScore = scores[index].addScore(score)

        return this.copy(
            scores = scores.toMutableList().replace(index, newScore)
        )
    }

    fun resetScore(): Player {
        return Player(name)
    }
}
