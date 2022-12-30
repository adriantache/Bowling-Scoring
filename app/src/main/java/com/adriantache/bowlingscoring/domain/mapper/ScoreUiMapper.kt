package com.adriantache.bowlingscoring.domain.mapper

import com.adriantache.bowlingscoring.domain.model.Score
import com.adriantache.bowlingscoring.domain.model.Score.LastScore
import com.adriantache.bowlingscoring.domain.model.Score.RegularScore
import com.adriantache.bowlingscoring.domain.model.ui.ScoreUi

fun Score.toUi(): ScoreUi {
    return when (this) {
        is LastScore -> ScoreUi.LastScore(scores)
        is RegularScore -> ScoreUi.RegularScore(scores)
    }
}
