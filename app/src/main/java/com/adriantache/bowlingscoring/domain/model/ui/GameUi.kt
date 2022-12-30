package com.adriantache.bowlingscoring.domain.model.ui

data class GameUi(
    val players: List<PlayerUi>,
    val currentPlayer: PlayerUi?,
    val shouldStart: Boolean,
    val isGameStarted: Boolean,
    val isGameOver: Boolean,
    val winningPlayer: PlayerUi,
)
