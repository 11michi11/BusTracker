package com.michi.bustrackerservice.domain

import reactor.core.publisher.Mono
import java.time.LocalDateTime

interface BusDepartureService {

    fun busDeparturesFromStopFromNow(busStopId: Int, dateTime: LocalDateTime, direction: String): BusDeparture

}
