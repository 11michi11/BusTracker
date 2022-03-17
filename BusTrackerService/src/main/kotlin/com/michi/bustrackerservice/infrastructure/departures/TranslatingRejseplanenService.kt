package com.michi.bustrackerservice.infrastructure.departures

import com.michi.bustrackerservice.domain.BusDeparture
import com.michi.bustrackerservice.domain.BusDepartureService
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@Service
class TranslatingRejseplanenService(val departureBoardAdapter: DepartureBoardAdapter) : BusDepartureService {

    override fun busDeparturesFromStopFromNow(busStopId: Int, dateTime: LocalDateTime, direction: String): BusDeparture {
        val dateAndTime = convertDateTimeToDateAndTime(dateTime)
        return departureBoardAdapter.getBusDepartures(busStopId, dateAndTime.first, dateAndTime.second, direction)
    }

    private fun convertDateTimeToDateAndTime(dateTime: LocalDateTime): Pair<String, String> {
        val date = dateTime.format(DateTimeFormatter.ofPattern("dd.MM.YYYY"))!!
        val time = dateTime.format(DateTimeFormatter.ofPattern("HH:mm"))!!
        return Pair(date, time)
    }

}
