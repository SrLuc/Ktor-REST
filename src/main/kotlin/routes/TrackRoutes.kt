package com.example.routes

import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.http.*
import com.example.models.Track
import com.example.controllers.TrackController

fun Application.configureTrackRoutes() {
    routing {
        get("/tracks") {
            call.respond(HttpStatusCode.OK, TrackController.getAll())
        }

        post("/tracks") {
            val track = call.receive<Track>()
            val newTrack = TrackController.addTrack(track)
            call.respond(HttpStatusCode.Created, newTrack)
        }

        put("/tracks/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
                ?: return@put call.respond(HttpStatusCode.BadRequest, "Invalid ID")
            val track = call.receive<Track>()
            val updatedTrack = TrackController.updateTrack(id, track)
            if (updatedTrack == null) {
                call.respond(HttpStatusCode.NotFound, "Track not found")
            } else {
                call.respond(HttpStatusCode.OK, updatedTrack)
            }
        }

        delete("/tracks/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
                ?: return@delete call.respond(HttpStatusCode.BadRequest, "Invalid ID")
            val deletedTrack = TrackController.deleteTrack(id)
            if (deletedTrack == null) {
                call.respond(HttpStatusCode.NotFound, "Track not found")
            } else {
                call.respond(HttpStatusCode.NoContent)
            }
        }
    }
}
