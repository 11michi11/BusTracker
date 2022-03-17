package com.michi.bustrackerservice.domain

interface KeyboardService {

    fun busApproaching()

    fun busGettingClose()

    fun busArrived()

    fun busDeparted()

    fun busTooFar()

}
