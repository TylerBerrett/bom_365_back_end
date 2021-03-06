package com.tylerb.util

import com.google.gson.Gson
import com.tylerb.model.MonthParent
import com.tylerb.network.CallBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
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



fun populateDataBase(lang: String = "eng") {
    val langSet = setOf("spa", "por")
    var finalLang = lang
    if (!langSet.contains(lang)) {
        finalLang = "eng"
    }

    val months = ScriptureReference().months

    val verseBlockList = ArrayList<ArrayList<String>>()
    val verseList = ArrayList<String>()

    for (month in months) {
        val monthString = monthString(month.key, finalLang)
        transaction {
            SchemaUtils.create(MonthParent(monthString))
        }

        for (day in month.value) {
            val dayInt = day.key
            val verses = day.value

            verseBlockList.clear()
            verseList.clear()
            for (i in verses.indices step 3) {
                val ref = verses[i]
                val deferred = GlobalScope.async {
                    CallBuilder.getScripture().getBook(finalLang, "/scriptures/bofm/$ref")
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
                        val sortedList = verseBlockList.sortedBy {
                                list -> list[0].split(" ")[1].replace(":", "").toInt()
                        }
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
                        println(finalTitle)
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