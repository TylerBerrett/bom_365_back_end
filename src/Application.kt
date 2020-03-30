package com.tylerb

import com.fasterxml.jackson.databind.SerializationFeature
import com.google.gson.Gson
import com.tylerb.model.MonthParent
import com.tylerb.model.Test
import com.tylerb.util.monthString
import com.tylerb.util.populateDataBase
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.response.*
import io.ktor.routing.get
import io.ktor.routing.routing
import kotlinx.coroutines.InternalCoroutinesApi
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

data class Response(val main_title: String, val scriptures: ArrayList<String>)
val test_scriptures = arrayListOf("Ether 1: 1-43", "1 and it", "2 came to pass", "Ether 2: 1-12", "1 after I", "2 was born")
val test_response = Response("Ether 1: 1-43 - Ether 2:1-12", test_scriptures)

fun initDB() {
    val url = System.getenv("BOM_URL")
    val pass = System.getenv("BOM_PASS")
    Database.connect(url, driver = "org.postgresql.Driver", password = pass)
}

fun getData(monthInt: Int, dayInt: Int): Response{
    var title = ""
    var scriptures = ArrayList<String>()
    transaction {
        val month = MonthParent(monthString(monthInt))
        val day = month.select {
            month.day.eq(dayInt)
        }
        day.map {
            title = it[month.title]
            scriptures = Gson().fromJson(it[month.scripture], ArrayList<String>().javaClass)
        }
    }
    return Response(title, scriptures)
}




@InternalCoroutinesApi
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    initDB()
    //populateDataBase()
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
        routing {
            get("/scripture/{month}/{day}") {
                val month = call.parameters["month"]!!.toInt() - 1
                val day = call.parameters["day"]!!.toInt()
                call.respond(getData(month, day))

            }
        }
    }
}

