package com.michi.bustrackerservice.domain


interface BusService {

    fun getNextBusDeparture(busStopId: Int, direction: String): BusDeparture

}
