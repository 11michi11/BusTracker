package com.michi.bustrackerservice

import com.michi.bustrackerservice.domain.BusService
import com.michi.bustrackerservice.domain.BusTrackerService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class BusTrackerScheduler(
    val busTrackerService: BusTrackerService
) {

    @Scheduled(fixedDelay = 60 * 1000)
    fun runTrackerSchedule() {
        busTrackerService.checkDepartureForBusStop(751428904, "Logistikparken")
    }

}
