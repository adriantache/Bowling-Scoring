package com.adriantache.bowlingscoring.domain.mapper

import com.adriantache.bowlingscoring.domain.model.Game
import com.adriantache.bowlingscoring.domain.model.ui.GameUi

fun Game.toUi(): GameUi {
    return GameUi(
        players = players.map { it.toUi() },
        currentPlayer = currentPlayer?.toUi(),
        shouldStart = shouldStart,
        isGameStarted = isGameStarted,
        isGameOver = isGameOver,
        winningPlayer = winningPlayer.toUi(),
    )
}
