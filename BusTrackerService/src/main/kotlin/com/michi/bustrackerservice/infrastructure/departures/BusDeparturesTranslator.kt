package com.michi.bustrackerservice.infrastructure.departures

import com.michi.bustrackerservice.domain.BusDeparture
import org.springframework.stereotype.Service

@Service
class BusDeparturesTranslator {

    fun toBusDeparture(journeyDetail: JourneyDetail, departure: Departure): BusDeparture {
        val busStop = departure.stop!!
        val stop = getStopFromJourney(journeyDetail, busStop)
        val dateTime = stop.getDateTime()
        val line = departure.line!!
        val (currentStop, stopsToDestination) = CurrentStopFactory().determineCurrentStopFromJourney(journeyDetail, busStop)

        return BusDeparture(busStop, dateTime, line, currentStop, stopsToDestination)
    }


    private fun getStopFromJourney(journeyDetail: JourneyDetail, stopName: String): Stop {
        return journeyDetail.Stop.find {
            it.name == stopName
        }!!
    }

}
