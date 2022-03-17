package com.michi.bustrackerservice.infrastructure.departures

import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class CurrentStopFactory {

    fun determineCurrentStopFromJourney(journeyDetail: JourneyDetail, destination: String): CurrentStop {
        val now = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY HH:mm")

        var remainingStopsToDestination = journeyDetail.Stop.dropWhile {
            if(it.routeIdx == 0) {
                return@dropWhile true
            }
            it.getDateTime().isBefore(now)
        }

        remainingStopsToDestination = remainingStopsToDestination.takeWhile {
            it.name != destination
        }

        val stopName = when {
            remainingStopsToDestination.isEmpty() -> destination
            else -> remainingStopsToDestination.first().name
        }

        return CurrentStop(stopName, remainingStopsToDestination.size)
    }

}
