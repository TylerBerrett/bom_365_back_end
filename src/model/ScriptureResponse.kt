package com.tylerb.model

import org.jetbrains.exposed.sql.Table

class Meta(val title: String)

class Content(val body: String)

class ScriptureResponse(val meta: Meta, val content: Content)

object Test: Table() {
    val name = varchar("name", 256)
    val num = integer("num")
}

class MonthParent(tableName: String): Table(tableName) {
    val day = integer("day").primaryKey()
    val title = text("title")
    val scripture = text("scripture")
}
