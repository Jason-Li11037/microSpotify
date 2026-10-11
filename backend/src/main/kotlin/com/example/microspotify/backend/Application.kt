package com.example.microspotify.backend

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module) // :: means the reference of a function
        .start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
        })
    }
    // TODO: adding the routing configuration here
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        // 0.0.0.0:8080/feed => Home
        get("/feed") {
            call.respondText("feed")
        }

        // 0.0.0.0:8080/playlists => Playlist
        get("/playlists") {
            call.respondText("playlists")
        }

        // 0.0.0.0:8080/playlist/{id}

        // 0.0.0.0:8080/songs/solo.mp3 => download/stream music
    }

    // Lambda argument should be moved out of parentheses
    myRouting {
        println("do something")

        myGet("/") {

        }
    }
}

// when lambda is the last parameter of a functin
fun myRouting(block: () -> Unit) {

}

fun myGet(path: String, block: () -> Unit) {

}
