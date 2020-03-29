package com.tylerb.util

import com.tylerb.network.CallBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
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

fun populateDataBase() {

    val months = ScriptureReference().months

    val verseBlockList = ArrayList<ArrayList<String>>()
    val verseList = ArrayList<String>()

    for (month in months) {
        if (month.key == 1) break
        val monthString = month.key
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
                        // Handle logic for adding to db here
                        println(finalTitle)
                    }
                }
            }
        }
    }
}