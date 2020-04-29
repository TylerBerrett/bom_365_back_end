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
import io.ktor.html.respondHtml
import io.ktor.jackson.jackson
import io.ktor.response.*
import io.ktor.routing.get
import io.ktor.routing.routing
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.html.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.net.URI
import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

data class Response(val main_title: String, val scriptures: ArrayList<String>)

fun initDB() {
    val url = System.getenv("JDBC_DATABASE_URL")
    Database.connect(url, driver = "org.postgresql.Driver")
}

fun getData(monthInt: Int, dayInt: Int, lang: String = "eng"): Response{
    var title = ""
    var scriptures = ArrayList<String>()
    transaction {
        val month = MonthParent(monthString(monthInt, lang))
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
    populateDataBase()
    populateDataBase("spa")
    populateDataBase("por")
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
        routing {
            get("/scripture/{month}/{day}/{lang?}") {
                val month = call.parameters["month"]!!.toInt() - 1
                val day = call.parameters["day"]!!.toInt()
                val lang = call.parameters["lang"] ?: "eng"
                call.respond(getData(month, day, lang))
            }
            get("/display/{lang?}") {
                val month = Calendar.getInstance().get(Calendar.MONTH)
                val day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                val lang = call.parameters["lang"] ?: "eng"
                val data = getData(month, day, lang)
                val style = """ul {list-style: none; margin: 18px; } h1 {text-align:center;} li {margin: 8px;}"""
                call.respondHtml {
                    body {
                        style { unsafe { raw(style) } }
                        h1 {
                            +data.main_title
                        }
                        ul {
                            data.scriptures.forEach {
                                li { +it }
                            }
                        }
                    }
                }
            }
        }
    }
}

