package com.michi.bustrackerservice.infrastructure.departures

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URI
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class DepartureBoardResponse(
    @JsonProperty("DepartureBoard")
    val DepartureBoard: DepartureBoard
)

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class DepartureBoard(
    val noNamespaceSchemaLocation: String,
    @JsonProperty("Departure")
    val Departure: ArrayList<Departure>,
)

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class Departure(
    val name: String?,
    val type: String?,
    val stop: String?,
    val time: String?,
    val date: String?,
    val id: String?,
    val line: String?,
    val messages: String?,
    val finalStop: String?,
    val direction: String?,
    @JsonProperty("JourneyDetailRef")
    val JourneyDetailRef: JourneyDetailRef?
)

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class JourneyDetailRef(
    val ref: URI
)

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class JourneyDetailsResponse(
    @JsonProperty("JourneyDetail")
    val JourneyDetail: JourneyDetail
)

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class JourneyDetail(
    val noNamespaceSchemaLocation: String?,
    @JsonProperty("Stop")
    val Stop: ArrayList<Stop>,
    @JsonProperty("JourneyName")
    val JourneyName: JourneyName,
    @JsonProperty("JourneyType")
    val JourneyType: JourneyType,
    @JsonProperty("JourneyLine")
    val JourneyLine: JourneyLine,
)

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class JourneyLine(
    val line: String,
    val routeIdxFrom: Int,
    val routeIdxTo: Int
)

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class JourneyType(
    val type: String,
    val routeIdxFrom: Int,
    val routeIdxTo: Int
)

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class JourneyName(
    val name: String,
    val routeIdxFrom: Int,
    val routeIdxTo: Int
)

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class Stop(
    val name: String,
    val x: String,
    val y: String,
    val routeIdx: Int,
    val arrTime: String?,
    val arrDate: String?,
    val depTime: String?,
    val depDate: String?,
    val track: String?,
    val rtDepTime: String?,
    val rtDepDate: String?,
    val rtArrTime: String?,
    val rtArrDate: String?
) {

    fun getDateTime(): LocalDateTime {
        val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yy")
        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        val date = LocalDate.parse((this.rtArrDate ?: this.arrDate), dateFormatter)
        val time = LocalTime.parse((this.rtArrTime ?: this.arrTime) + ":00", timeFormatter)
        return LocalDateTime.of(date, time)
    }

}

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class CurrentStop(
    val name: String,
    val stopsToDestination: Int
)

