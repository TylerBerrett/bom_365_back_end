package com.tylerb.util

import java.util.*

fun monthString(monthInt: Int, lang: String = "eng"): String{
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
    val mapSpanish = mapOf(
        Calendar.JANUARY to "Enero",
        Calendar.FEBRUARY to "Febrero",
        Calendar.MARCH to "Marzo",
        Calendar.APRIL to "Abril",
        Calendar.MAY to "Mayo",
        Calendar.JUNE to "Junio",
        Calendar.JULY to "Julio",
        Calendar.AUGUST to "Agosto",
        Calendar.SEPTEMBER to "Septiembre",
        Calendar.OCTOBER to "Octubre",
        Calendar.NOVEMBER to "Noviembre",
        Calendar.DECEMBER to "Diciembre"
    )
    val mapPortuguese = mapOf(
        Calendar.JANUARY to "Janeiro",
        Calendar.FEBRUARY to "Fevereiro",
        Calendar.MARCH to "Março",
        Calendar.APRIL to "Abril(Portuguese)",
        Calendar.MAY to "Maio",
        Calendar.JUNE to "Junho",
        Calendar.JULY to "Julho",
        Calendar.AUGUST to "Agosto(Portuguese)",
        Calendar.SEPTEMBER to "Setembro",
        Calendar.OCTOBER to "Outubro",
        Calendar.NOVEMBER to "Novembro",
        Calendar.DECEMBER to "Dezembro"
    )

    return when (lang.toLowerCase()) {
        "spa" ->  mapSpanish.getValue(monthInt)
        "por" -> mapPortuguese.getValue(monthInt)
        else -> map.getValue(monthInt)
    }
}