package com.adriantache.bowlingscoring.domain.model

import com.adriantache.bowlingscoring.domain.model.Score.Companion.hasScore
import com.adriantache.bowlingscoring.domain.util.extension.replace

data class Game(
    val players: List<Player> = emptyList(),
    val currentPlayer: Player? = null,
) {
    val shouldStart = players.isNotEmpty()

    val isGameStarted = players.any { it.scores.hasScore() }

    val isGameOver = players.all { it.isGameOver }

    val winningPlayer = players.maxBy { it.totalScore }

    fun submitScore(pinsDowned: Int): Game {
        val currentPlayer = currentPlayer ?: players.first()
        val index = players.indexOf(currentPlayer)

        val newScore = currentPlayer.addScore(pinsDowned)
        val newPlayers = players.toMutableList().replace(index, newScore)

        val nextIndex = if (index + 1 == players.size) 0 else index + 1
        val nextPlayer = players[nextIndex]

        return Game(
            players = newPlayers,
            currentPlayer = nextPlayer,
        )
    }

    fun addPlayer(name: String): Game {
        val newPlayer = Player(name)

        return this.copy(
            players = players + newPlayer,
            currentPlayer = currentPlayer ?: newPlayer,
        )
    }

    fun resetGame(keepPlayers: Boolean): Game {
        val players = if (keepPlayers) players.map { it.resetScore() } else emptyList()
        return Game(players)
    }
}
