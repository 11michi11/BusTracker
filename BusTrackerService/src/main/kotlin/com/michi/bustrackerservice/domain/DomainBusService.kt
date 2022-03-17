package com.michi.bustrackerservice.domain

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@Service
class DomainBusService(val busDepartureService: BusDepartureService): BusService {

    override fun getNextBusDeparture(busStopId: Int, direction: String): BusDeparture {
        return busDepartureService.busDeparturesFromStopFromNow(busStopId, LocalDateTime.now(), direction)
    }


}
