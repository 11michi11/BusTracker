package com.michi.bustrackerservice.infrastructure.keyboard

data class Signal(
    val id: Int? = 0,
    val name: String? = "",
    val message: String? = "",
    val zoneId: String,
    val color: String? = "",
    val effect: String? = "",
    val pid: String,
    val isArchived: Boolean? = false,
    val isRead: Boolean? = false,
    val isMuted: Boolean? = false,
    val userId: Int? = 0,
    val clientName: String,
    val createdAt: Long? = 0,
    val updatedAt: Long? = 0
) {
    fun isError(): Boolean {
        return this == SignalFactory().createErrorSignal()
    }
}


enum class Effect(val effect: String) {
    SET_COLOR("SET_COLOR")
}

enum class Color(val hex: String) {
    RED("#FF0000"),
    GREEN("#00FF00"),
    YELLOW("#FFFF33"),
    BLACK("#000000")
}

class SignalFactory() {

    companion object {
        const val PID_5Q = "DK5QPID"
        const val CLIENT_NAME = "Spring Boot"
    }

    fun createSetColorSignalFor5QKeyboard(key: String, color: String, message: String, name: String) =
        Signal(
            name = name,
            message = message,
            zoneId = key,
            color = color,
            effect = Effect.SET_COLOR.name,
            pid = PID_5Q,
            clientName = CLIENT_NAME
        )

    fun deleteSignalFor5QKeyboard(key: String) =
        Signal(
            zoneId = key,
            pid = PID_5Q,
            clientName = CLIENT_NAME
        )

    fun createErrorSignal() =
        Signal(
            name = "Error",
            message = "Error",
            zoneId = "Error",
            pid = PID_5Q,
            id = 0,
            clientName = "Error"
        )

}
