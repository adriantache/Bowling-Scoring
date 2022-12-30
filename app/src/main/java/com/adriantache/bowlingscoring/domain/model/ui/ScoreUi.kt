package com.adriantache.bowlingscoring.domain.model.ui

sealed class ScoreUi(
    open val scores: List<Int?>,
) {
    class RegularScore(override val scores: List<Int?>) : ScoreUi(scores)
    class LastScore(override val scores: List<Int?>) : ScoreUi(scores)
}
