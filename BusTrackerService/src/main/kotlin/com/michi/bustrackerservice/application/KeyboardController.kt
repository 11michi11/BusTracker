package com.michi.bustrackerservice.application

import com.michi.bustrackerservice.domain.KeyboardService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/keyboard")
class KeyboardController(val keyboardService: KeyboardService) {

    @PostMapping("/approaching")
    fun busApproaching() {
        keyboardService.busApproaching()
    }

    @PostMapping("/close")
    fun busGettingClose() {
        keyboardService.busGettingClose()
    }

    @PostMapping("/arrived")
    fun busArrived() {
        keyboardService.busArrived()
    }

}
