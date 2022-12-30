package com.adriantache.bowlingscoring.domain.model

import com.adriantache.bowlingscoring.domain.util.extension.getOrZero
import com.adriantache.bowlingscoring.domain.util.extension.replace
import com.adriantache.bowlingscoring.domain.util.extension.sum

private const val STRIKE = 10

sealed class Score(
    open val scores: List<Int?>,
) {
    val isComplete: Boolean
        get() = scores.none { it == null }

    val hasScore: Boolean
        get() = scores.any { it != null }

    abstract fun addScore(score: Int): Score

    class RegularScore(
        override val scores: List<Int?> = List(2) { null }
    ) : Score(scores) {
        val isStrike = scores[0] == STRIKE
        val isSpare = !isStrike && scores.sum() == STRIKE

        override fun addScore(score: Int): RegularScore {
            val index = scores.indexOfFirst { it == null }.takeIf { it != -1 } ?: throw IllegalStateException("Score is complete!")
            return RegularScore(
                scores.toMutableList().replace(index, score)
            )
        }
    }

    class LastScore(
        override val scores: List<Int?> = List(2) { null }
    ) : Score(scores) {
        val isFirstStrike = scores[0] == STRIKE
        val isSecondStrike = scores[1] == STRIKE
        val isThirdStrike = scores[2] == STRIKE

        val isFirstSpare = !isFirstStrike && scores.getOrZero(0) + scores.getOrZero(1) == STRIKE
        val isSecondSpare = !isSecondStrike && scores.getOrZero(1) + scores.getOrZero(2) == STRIKE

        override fun addScore(score: Int): LastScore {
            val index = scores.indexOfFirst { it == null }.takeIf { it != -1 } ?: throw IllegalStateException("Score is complete!")
            return LastScore(
                scores.toMutableList().replace(index, score)
            )
        }
    }

    companion object {
        fun getFrames(): List<Score> {
            return List(10) { if (it < 9) RegularScore() else LastScore() }
        }

        fun List<Score>.sum(): Int {
            return this.fold(0) { acc, score ->
                val scoreSum = when (score) {
                    is LastScore -> score.scores.sum()
                    is RegularScore -> score.scores.sum()
                }

                return acc + scoreSum
            }
        }

        fun List<Score>.isGameOver(): Boolean {
            return this.all { it.isComplete }
        }

        fun List<Score>.hasScore(): Boolean {
            return this.any { it.hasScore }
        }
    }
}
