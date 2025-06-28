package com.example

import io.ktor.serialization.kotlinx.json.*

import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.request.receive
import io.netty.handler.codec.http2.Http2PushPromiseFrame
import kotlinx.serialization.Serializable

@Serializable
data class  User(var id:Int, val name: String, val age: Int)

val users = mutableListOf<User>()

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/users") {
            call.respond(HttpStatusCode.OK, users)
        }

        post("/users") {
            val body = call.receive<User>()
            val user = User(users.size + 1, body.name, body.age)
            users.add(user)
            call.respond(HttpStatusCode.Created, user)
        }

        put("/users/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            val index = users.indexOfFirst { it.id == id }
            val body = call.receive<User>()

            if (index == -1) {
                call.respond(HttpStatusCode.NotFound, "Usuário não encontrado")
                return@put
            } else if (id == null) {
                call.respond(HttpStatusCode.BadRequest, "ID inválido")
                return@put
            }

            users[index] = User(id, body.name, body.age)
            call.respond(HttpStatusCode.OK, users[index])
        }

        delete("/users/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            val index = users.indexOfFirst { it.id == id }

            if (index == -1) {
                call.respond(HttpStatusCode.NotFound, "Usuário não encontrado")
                return@delete
            } else if (id == null) {
                call.respond(HttpStatusCode.BadRequest, "ID inválido")
                return@delete
            }

            val user = users.removeAt(index)
            call.respond(HttpStatusCode.NoContent, user)

        }
    }
}
