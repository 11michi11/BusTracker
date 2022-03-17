package com.michi.bustrackerservice.application

import com.michi.bustrackerservice.domain.BusDeparture
import com.michi.bustrackerservice.domain.BusService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/departures")
class BusTrackerController(val busService: BusService) {

    @GetMapping("/{busStopId}/{direction}/next")
    fun getNextBusDeparture(@PathVariable busStopId: Int, @PathVariable direction: String): BusDeparture {
        return busService.getNextBusDeparture(busStopId, direction)
    }


}
