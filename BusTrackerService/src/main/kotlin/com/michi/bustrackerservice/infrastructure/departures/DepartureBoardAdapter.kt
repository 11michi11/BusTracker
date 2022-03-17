package com.michi.bustrackerservice.infrastructure.departures

import com.michi.bustrackerservice.domain.BusDeparture
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.net.URI

@Service
class DepartureBoardAdapter {

    var logger: Logger = LoggerFactory.getLogger(DepartureBoardAdapter::class.java)

    companion object {
        const val REJSEPLANEN_BASE_URL = "http://xmlopen.rejseplanen.dk/bin/rest.exe"
        const val DEPARTURE_BOARD_URL = "/departureBoard"
    }

    fun getBusDepartures(busStopId: Int, date: String, time: String, direction: String): BusDeparture {
        val departureBoard = getDepartureBoard(busStopId, date, time).block()
        logger.info(departureBoard.toString())
        val firstDeparture = getFirstDepartureInDirection(departureBoard!!.Departure, direction)
        val journeyDetails = getJourneyDetails(firstDeparture.JourneyDetailRef!!.ref).block()!!
        return BusDeparturesTranslator().toBusDeparture(journeyDetails, firstDeparture)
    }

    private fun getFirstDepartureInDirection(departures: List<Departure>, direction: String): Departure {
        return departures.find {
            it.direction == direction
        }!!
    }

    private fun getDepartureBoard(busStopId: Int, date: String, time: String): Mono<DepartureBoard> {
        return WebClient.builder()
            .baseUrl(REJSEPLANEN_BASE_URL + DEPARTURE_BOARD_URL)
            .build()
            .get()
            .uri { uriBuilder ->
                uriBuilder.queryParam("id", busStopId)
                    .queryParam("date", date)
                    .queryParam("time", time)
                    .queryParam("format", "json").build()
            }
            .retrieve()
            .bodyToMono(DepartureBoardResponse::class.java).map { it.DepartureBoard }
    }

    private fun getJourneyDetails(journeyRef: URI): Mono<JourneyDetail> {
        return WebClient.create()
            .get()
            .uri(journeyRef)
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .retrieve()
            .bodyToMono(JourneyDetailsResponse::class.java).map { it.JourneyDetail }
    }

}
