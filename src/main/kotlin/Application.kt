package com.example
import com.example.routes.configureTrackRoutes
import io.ktor.server.application.*
import com.example.database.configureDatabaseConection


fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
    configureTrackRoutes()
    configureDatabaseConection()
}
