package com.michi.bustrackerservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class BusTrackerServiceApplication

fun main(args: Array<String>) {
    runApplication<BusTrackerServiceApplication>(*args)
}


