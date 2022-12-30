package com.adriantache.bowlingscoring.domain

import com.adriantache.bowlingscoring.domain.BowlingGameStates.*
import com.adriantache.bowlingscoring.domain.mapper.toUi
import com.adriantache.bowlingscoring.domain.model.Game
import kotlinx.coroutines.flow.MutableStateFlow

class BowlingGameUseCase : BowlingGameUseCaseInterface {
    override val state: MutableStateFlow<BowlingGameStates> = MutableStateFlow(Initializing(::init))

    private var game = Game()

    private fun init() {
        state.value = ReadyForPlayers(::addPlayer)
    }

    private fun addPlayer(name: String) {
        game = game.addPlayer(name)

        if (game.shouldStart) {
            startGame()
        }
    }

    private fun resetGame(keepPlayers: Boolean) {
        game = game.resetGame(keepPlayers)
    }

    private fun submitScore(pinsDowned: Int) {
        game.submitScore(pinsDowned)
    }

    private fun startGame() {
        state.value = GameStarted(
            game = game.toUi(),
            canAddPlayer = !game.isGameStarted,
            addPlayer = ::addPlayer,
            setScore = ::submitScore,
            resetGame = ::resetGame,
        )
    }
}
