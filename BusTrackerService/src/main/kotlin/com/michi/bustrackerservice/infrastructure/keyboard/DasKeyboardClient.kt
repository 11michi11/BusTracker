package com.michi.bustrackerservice.infrastructure.keyboard

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono


@Service
class DasKeyboardClient {

    var logger: Logger = LoggerFactory.getLogger(DasKeyboardClient::class.java)

    companion object {
        const val DASKEYBOARD_BASE_URL = "http://localhost:27301"
        const val SIGNALS_URL = "/api/1.0/signals"
    }

    fun sendSignal(key: String, color: String, name: String, message: String): Signal {
        val signal = SignalFactory().createSetColorSignalFor5QKeyboard(key, color, message, name)
        logger.info("Sending signal: $signal")
        return WebClient.builder()
            .baseUrl(DASKEYBOARD_BASE_URL + SIGNALS_URL)
            .build()
            .post()
            .body(BodyInserters.fromValue(signal))
            .retrieve()
            .bodyToMono<Signal>().block()!!
    }

    fun deleteSignal(key: String): Signal {
        val signal = SignalFactory().deleteSignalFor5QKeyboard(key)
        val signalToDelete = getSignalForKey(signal.zoneId, signal.pid)

        if(signalToDelete.isError()) {
            return signal
        }

        logger.info("Sending signal: $signal")
        return WebClient.builder()
            .baseUrl(DASKEYBOARD_BASE_URL + SIGNALS_URL + "/" + signalToDelete.id)
            .build()
            .delete()
            .retrieve()
            .bodyToMono<Signal>().block()!!
    }

    fun getSignalForKey(key: String, pid: String): Signal {
        return WebClient.builder()
            .baseUrl(DASKEYBOARD_BASE_URL + SIGNALS_URL + "/pid/" + pid + "/zoneId/" + key)
            .build()
            .get()
            .retrieve()
            .bodyToMono<Signal>()
            .onErrorResume {
                Mono.from<Signal> {
                    SignalFactory().createErrorSignal()
                }
            }
            .block()!!
    }

}

