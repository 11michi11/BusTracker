package com.michi.bustrackerservice

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.michi.bustrackerservice.infrastructure.departures.DepartureBoardResponse
import com.michi.bustrackerservice.infrastructure.keyboard.DasKeyboardClient
import com.michi.bustrackerservice.infrastructure.keyboard.KeyboardAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

//@Component
class BusTrackerRunner(val keyboardAdapter: KeyboardAdapter): CommandLineRunner {
    var logger: Logger = LoggerFactory.getLogger(BusTrackerRunner::class.java)

    override fun run(vararg args: String?) {
        keyboardAdapter.busApproaching()
        Thread.sleep(15000)

        keyboardAdapter.busGettingClose()
        Thread.sleep(15000)

        keyboardAdapter.busArrived()
        Thread.sleep(15000)

        keyboardAdapter.busDeparted()
        Thread.sleep(15000)

        keyboardAdapter.busTooFar()
        Thread.sleep(15000)


    //        val response = jacksonObjectMapper().readValue<DepartureBoardResponse>(json)
//        logger.info(response.toString())
    }

    companion object {
        val json = """
            {
            "DepartureBoard":{
              "noNamespaceSchemaLocation":"http://webapp.rejseplanen.dk/xml/rest/hafasRestDepartureBoard.xsd",
              "Departure":[{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"21:52",
                "date":"28.01.22",
                "id":"751428903",
                "line":"12",
                "messages":"1",
                "finalStop":"Logistikparken/Rosbjergvej",
                "direction":"Logistikparken",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=707460%2F269600%2F351238%2F60201%2F86%3Fdate%3D28.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"21:55",
                "date":"28.01.22",
                "id":"751428904",
                "line":"12",
                "messages":"1",
                "finalStop":"Hjortshøj/Hjortshøjvangen (Aarhus Kom)",
                "direction":"Hjortshøj",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=806610%2F302703%2F627342%2F44801%2F86%3Fdate%3D28.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"22:52",
                "date":"28.01.22",
                "id":"751428903",
                "line":"12",
                "messages":"1",
                "finalStop":"Logistikparken/Rosbjergvej",
                "direction":"Logistikparken",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=683040%2F261479%2F577384%2F61012%2F86%3Fdate%3D28.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"22:55",
                "date":"28.01.22",
                "id":"751428904",
                "line":"12",
                "messages":"1",
                "finalStop":"Mejlby/Gl. Kaløvej (Aarhus Kom)",
                "direction":"Mejlby",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=29211%2F43553%2F757000%2F368764%2F86%3Fdate%3D28.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"23:52",
                "date":"28.01.22",
                "id":"751428903",
                "line":"12",
                "messages":"1",
                "finalStop":"Logistikparken/Rosbjergvej",
                "direction":"Logistikparken",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=98880%2F66740%2F468778%2F201430%2F86%3Fdate%3D28.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"23:55",
                "date":"28.01.22",
                "id":"751428904",
                "line":"12",
                "messages":"1",
                "finalStop":"Hjortshøj/Hjortshøjvangen (Aarhus Kom)",
                "direction":"Hjortshøj",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=167430%2F89643%2F735524%2F311953%2F86%3Fdate%3D28.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"00:52",
                "date":"29.01.22",
                "id":"751428903",
                "line":"12",
                "messages":"1",
                "finalStop":"Logistikparken/Rosbjergvej",
                "direction":"Logistikparken",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=834729%2F312042%2F400636%2F77926%2F86%3Fdate%3D29.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"06:52",
                "date":"29.01.22",
                "id":"751428903",
                "line":"12",
                "messages":"1",
                "finalStop":"Logistikparken/Rosbjergvej",
                "direction":"Logistikparken",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=822915%2F308108%2F16666%2F265972%2F86%3Fdate%3D29.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"06:55",
                "date":"29.01.22",
                "id":"751428904",
                "line":"12",
                "messages":"1",
                "finalStop":"Mejlby/Gl. Kaløvej (Aarhus Kom)",
                "direction":"Mejlby",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=279969%2F127144%2F17326%2F84660%2F86%3Fdate%3D29.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"07:52",
                "date":"29.01.22",
                "id":"751428903",
                "line":"12",
                "messages":"1",
                "finalStop":"Logistikparken/Rosbjergvej",
                "direction":"Logistikparken",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=377238%2F159530%2F498480%2F123494%2F86%3Fdate%3D29.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"07:55",
                "date":"29.01.22",
                "id":"751428904",
                "line":"12",
                "messages":"1",
                "finalStop":"Hjortshøj/Hjortshøjvangen (Aarhus Kom)",
                "direction":"Hjortshøj",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=564399%2F221970%2F971726%2F297730%2F86%3Fdate%3D29.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"08:44",
                "date":"29.01.22",
                "id":"751428904",
                "line":"12",
                "messages":"1",
                "finalStop":"Mejlby/Gl. Kaløvej (Aarhus Kom)",
                "direction":"Mejlby",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=426867%2F176110%2F412012%2F63718%2F86%3Fdate%3D29.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"08:52",
                "date":"29.01.22",
                "id":"751428903",
                "line":"12",
                "messages":"1",
                "finalStop":"Logistikparken/Rosbjergvej",
                "direction":"Logistikparken",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=237234%2F112881%2F117838%2F20160%2F86%3Fdate%3D29.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"09:14",
                "date":"29.01.22",
                "id":"751428904",
                "line":"12",
                "messages":"1",
                "finalStop":"Hjortshøj/Hjortshøjvangen (Aarhus Kom)",
                "direction":"Hjortshøj",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=771234%2F290915%2F619112%2F52479%2F86%3Fdate%3D29.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"09:41",
                "date":"29.01.22",
                "id":"751428904",
                "line":"12",
                "messages":"1",
                "finalStop":"Mejlby/Gl. Kaløvej (Aarhus Kom)",
                "direction":"Mejlby",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=194256%2F98579%2F226532%2F48514%2F86%3Fdate%3D29.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"09:52",
                "date":"29.01.22",
                "id":"751428903",
                "line":"12",
                "messages":"1",
                "finalStop":"Logistikparken/Rosbjergvej",
                "direction":"Logistikparken",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=432363%2F177905%2F603212%2F157486%2F86%3Fdate%3D29.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"10:11",
                "date":"29.01.22",
                "id":"751428904",
                "line":"12",
                "messages":"1",
                "finalStop":"Hjortshøj/Hjortshøjvangen (Aarhus Kom)",
                "direction":"Hjortshøj",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=862239%2F321258%2F828084%2F126629%2F86%3Fdate%3D29.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"10:39",
                "date":"29.01.22",
                "id":"751428903",
                "line":"12",
                "messages":"1",
                "finalStop":"Logistikparken/Rosbjergvej",
                "direction":"Logistikparken",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=340797%2F147413%2F726704%2F249753%2F86%3Fdate%3D29.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"10:41",
                "date":"29.01.22",
                "id":"751428904",
                "line":"12",
                "messages":"1",
                "finalStop":"Mejlby/Gl. Kaløvej (Aarhus Kom)",
                "direction":"Mejlby",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=602991%2F234824%2F276860%2F62568%2F86%3Fdate%3D29.01.22%26format%3Djson"
                  }
                },{
                "name":"Bybus 12",
                "type":"BUS",
                "stop":"Frichsparken/Søren Frichs Vej (Aarhus Kom)",
                "time":"11:09",
                "date":"29.01.22",
                "id":"751428903",
                "line":"12",
                "messages":"1",
                "finalStop":"Logistikparken/Rosbjergvej",
                "direction":"Logistikparken",
                "JourneyDetailRef":{
                  "ref":"http://webapp.rejseplanen.dk/bin//rest.exe/journeyDetail?ref=219915%2F107099%2F163654%2F8522%2F86%3Fdate%3D29.01.22%26format%3Djson"
                  }
                }]
              }
            }
        """.trimIndent()
    }

}
