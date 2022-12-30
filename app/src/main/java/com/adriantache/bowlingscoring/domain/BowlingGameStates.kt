package com.adriantache.bowlingscoring.domain

import com.adriantache.bowlingscoring.domain.model.ui.GameUi

sealed interface BowlingGameStates {
    class Initializing(callback: () -> Unit) : BowlingGameStates

    class ReadyForPlayers(addPlayer: (name: String) -> Unit) : BowlingGameStates

    class GameStarted(
        game: GameUi,
        canAddPlayer: Boolean,
        addPlayer: (name: String) -> Unit,
        setScore: (score: Int) -> Unit,
        resetGame: (keepPlayers: Boolean) -> Unit,
    ) : BowlingGameStates
}
