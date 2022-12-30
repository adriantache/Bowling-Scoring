package com.adriantache.bowlingscoring.domain.util.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EventTest {
    @Test
    fun `event, not consumed`() {
        val value = 1
        val event = Event(value)

        assertThat(event.value).isEqualTo(value)
    }

    @Test
    fun event() {
        val value = 1
        val event = Event(value)

        // Consume value
        event.value

        assertThat(event.value).isNull()
    }
}
