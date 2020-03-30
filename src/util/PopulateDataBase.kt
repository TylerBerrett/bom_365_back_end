package com.tylerb.util

import com.google.gson.Gson
import com.tylerb.model.MonthParent
import com.tylerb.network.CallBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.Month
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.jsoup.Jsoup
import java.util.*
import kotlin.collections.ArrayList

fun getParagraphs(htmlString: String, startVerse: Int, endVerse: Int): java.util.ArrayList<String> {
    val doc = Jsoup.parse(htmlString)
    val paragraphs = java.util.ArrayList<String>()

    for (i in startVerse..endVerse) {
        val paragraph = doc.body().getElementById("p$i")
        val markers = paragraph.getElementsByClass("marker")
        markers.remove()
        paragraphs.add(paragraph.text())
    }

    return paragraphs
}

fun monthString(montInt: Int): String{
    val map = mapOf(
        Calendar.JANUARY to "January",
        Calendar.FEBRUARY to "February",
        Calendar.MARCH to "March",
        Calendar.APRIL to "April",
        Calendar.MAY to "May",
        Calendar.JUNE to "June",
        Calendar.JULY to "July",
        Calendar.AUGUST to "August",
        Calendar.SEPTEMBER to "September",
        Calendar.OCTOBER to "October",
        Calendar.NOVEMBER to "November",
        Calendar.DECEMBER to "December"
    )
    return map.getValue(montInt)
}

fun populateDataBase() {

    val months = ScriptureReference().months

    val verseBlockList = ArrayList<ArrayList<String>>()
    val verseList = ArrayList<String>()

    for (month in months) {
        val monthString = monthString(month.key)
        transaction {
            SchemaUtils.create(MonthParent(monthString))
        }

        for (day in month.value) {
            val dayInt = day.key
            val verses = day.value

            // This is broken
            verseBlockList.clear()
            verseList.clear()
            for (i in verses.indices step 3) {
                val ref = verses[i]
                val deferred = GlobalScope.async {
                    CallBuilder.getScripture().getBook("eng", "/scriptures/bofm/$ref")
                }
                runBlocking {
                    val book = deferred.await()

                    val start = verses[i + 1].toInt()
                    val end = verses[i + 2].toInt()
                    val title = "${book.meta.title}: $start-$end"
                    val block = getParagraphs(book.content.body, start, end)
                    block.add(0, title)
                    verseBlockList.add(block)
                    if (verseBlockList.size == (verses.size / 3)) {
                        val sortedList = verseBlockList.sortedBy { list -> list[0] }
                        var finalTitle = sortedList.first()[0] + " - " + sortedList.last()[0]
                        sortedList.forEach { blockItem ->
                            blockItem.forEach { verse ->
                                verseList.add(verse)
                            }
                        }
                        if (sortedList.size == 1) {
                            finalTitle = sortedList.first()[0]
                            verseList.removeAt(0)
                        }
                        val json = Gson().toJson(verseList)
                        transaction {
                            MonthParent(monthString).insert {
                                it[this.day] = dayInt
                                it[this.title] = finalTitle
                                it[this.scripture] = json
                            }
                        }
                    }
                }
            }
        }
    }
}