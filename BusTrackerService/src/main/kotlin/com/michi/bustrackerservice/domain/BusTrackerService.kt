package com.michi.bustrackerservice.domain

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class BusTrackerService(
    val busService: BusService,
    val keyboardService: KeyboardService
) {

    var logger: Logger = LoggerFactory.getLogger(BusTrackerService::class.java)
    var currentState = BusState.TOO_FAR

    fun checkDepartureForBusStop(busStop: Int, direction: String) {
        val nextBusDeparture = busService.getNextBusDeparture(busStop, direction)
        val minutesToDeparture = nextBusDeparture.minutesToDeparture()
        logger.info(nextBusDeparture.toString())
        logger.info("Minutes to departure $minutesToDeparture")


        when {
            minutesToDeparture < 0L -> {
                if(currentState != BusState.DEPARTED) {
                    keyboardService.busDeparted()
                    currentState = BusState.DEPARTED
                }
            }
            minutesToDeparture in 0L..1L -> {
                if (currentState != BusState.ARRIVED) {
                    keyboardService.busArrived()
                    currentState = BusState.ARRIVED
                }
            }
            minutesToDeparture in 2L..5L -> {
                if(currentState != BusState.GETTING_CLOSE) {
                    keyboardService.busGettingClose()
                    currentState = BusState.GETTING_CLOSE
                }
            }
            minutesToDeparture in 6L..10L -> {
                if(currentState != BusState.APPROACHING) {
                    keyboardService.busApproaching()
                    currentState = BusState.APPROACHING
                }
            }
            else -> {
                if(currentState != BusState.TOO_FAR) {
                    keyboardService.busTooFar()
                    currentState = BusState.TOO_FAR
                }
            }
        }


    }

}

enum class BusState() {
    TOO_FAR,
    APPROACHING,
    GETTING_CLOSE,
    ARRIVED,
    DEPARTED
}
