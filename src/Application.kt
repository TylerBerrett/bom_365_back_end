package com.tylerb

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.http.HttpStatusCode
import io.ktor.jackson.jackson
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.get
import io.ktor.routing.routing
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import java.util.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

data class Response(val main_title: String, val scriptures: ArrayList<String>)
val test_scriptures = arrayListOf("Ether 1: 1-43", "1 and it", "2 came to pass", "Ether 2: 1-12", "1 after I", "2 was born")
val test_response = Response("Ether 1: 1-43 - Ether 2:1-12", test_scriptures)

@InternalCoroutinesApi
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
        routing {
            get("/test/{month}/{day}") {
                val month = call.parameters["month"]
                val day = call.parameters["day"]
                call.respond(test_response)
            }
        }
    }
}

