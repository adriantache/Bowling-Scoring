package com.adriantache.bowlingscoring.domain.mapper

import com.adriantache.bowlingscoring.domain.model.Player
import com.adriantache.bowlingscoring.domain.model.ui.PlayerUi

fun Player.toUi(): PlayerUi {
    return PlayerUi(
        name = name,
        scores = scores.map { it.toUi() },
    )
}
