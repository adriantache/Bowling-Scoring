package com.adriantache.bowlingscoring.domain.util.extension

fun List<Int?>.sum(): Int {
    return this.fold(0) { acc, value ->
        acc + (value ?: 0)
    }
}

fun List<Int?>.getOrZero(index: Int): Int {
    return this[index] ?: 0
}

fun <T> List<T>.replace(index: Int, element: T): List<T> {
    return this.toMutableList().replace(index, element)
}
