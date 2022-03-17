package com.michi.bustrackerservice.domain

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class BusDeparture(
    val busStop: String,
    val dateTime: LocalDateTime,
    val line: String,
    val currentStop: String,
    val stopsToDestination: Int
) {

    fun minutesToDeparture(): Long {
        return ChronoUnit.MINUTES.between(LocalDateTime.now(), dateTime)
    }

}
