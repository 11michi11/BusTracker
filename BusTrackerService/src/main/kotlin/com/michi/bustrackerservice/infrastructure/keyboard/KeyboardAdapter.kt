package com.michi.bustrackerservice.infrastructure.keyboard

import com.michi.bustrackerservice.domain.KeyboardService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class KeyboardAdapter(val dasKeyboardClient: DasKeyboardClient): KeyboardService {

    var logger: Logger = LoggerFactory.getLogger(KeyboardAdapter::class.java)

    override fun busApproaching() {
        val name = "Bus is approaching"
        val message = "Bus will arrive in 10 minutes"

        val response = dasKeyboardClient.sendSignal("KEY_W", Color.GREEN.hex, name, message)
        logger.info("Response from Keyboard: $response")
        logger.info("Bus approaching")
    }

    override fun busGettingClose() {
        val name = "Bus is getting close"
        val message = "Bus will arrive in 5 minutes"

        val response = dasKeyboardClient.sendSignal("KEY_W", Color.YELLOW.hex, name, message)
        logger.info("Response from Keyboard: $response")
        logger.info("Bus getting close")
    }

    override fun busArrived() {
        val name = "Bus has arrived"
        val message = "Bus has arrived"

        val response = dasKeyboardClient.sendSignal("KEY_W", Color.RED.hex, name, message)
        logger.info("Response from Keyboard: $response")
        logger.info("Bus arrived")
    }

    override fun busDeparted() {
        val name = "Bus has departed"
        val message = "Bus has has departed"

        val response = dasKeyboardClient.sendSignal("KEY_W", Color.BLACK.hex, name, message)
        logger.info("Response from Keyboard: $response")
        logger.info("Bus departed")
    }

    override fun busTooFar() {
        val response = dasKeyboardClient.deleteSignal("KEY_W")
        logger.info("Response from Keyboard: $response")
        logger.info("Bus too far")
    }

}
