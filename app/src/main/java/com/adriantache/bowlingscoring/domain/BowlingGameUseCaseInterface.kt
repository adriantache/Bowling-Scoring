package com.adriantache.bowlingscoring.domain

import kotlinx.coroutines.flow.MutableStateFlow

interface BowlingGameUseCaseInterface {
    val state: MutableStateFlow<BowlingGameStates>
}
