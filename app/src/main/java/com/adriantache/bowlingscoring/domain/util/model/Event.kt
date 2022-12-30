package com.adriantache.bowlingscoring.domain.util.model

class Event<T>(value: T) {
    private var isConsumed = false

    val value: T? = value
        @Synchronized
        get() = if (isConsumed) {
            null
        } else {
            isConsumed = true
            field
        }
}
