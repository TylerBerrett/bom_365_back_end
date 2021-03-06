package com.tylerb.util

import java.util.*


class ScriptureReference() {

    private val january = mapOf(
        1 to listOf("1-ne/1", "1", "15"),
        2 to listOf("1-ne/1", "16", "20", "1-ne/2", "1", "15"),
        3 to listOf("1-ne/2", "16", "24", "1-ne/3", "1", "8"),
        4 to listOf("1-ne/3", "9", "31"),
        5 to listOf("1-ne/4", "1", "18"),
        6 to listOf("1-ne/4", "19", "38", "1-ne/5", "1", "6"),
        7 to listOf("1-ne/5", "7", "22", "1-ne/6", "1", "6"),
        8 to listOf("1-ne/7", "1", "15"),
        9 to listOf("1-ne/7", "16", "22", "1-ne/8", "1", "15"),
        10 to listOf("1-ne/8", "16", "38"),
        11 to listOf("1-ne/9", "1", "6", "1-ne/10", "1", "10"),
        12 to listOf("1-ne/10", "10", "22", "1-ne/11", "1", "11"),
        13 to listOf("1-ne/11", "12", "30"),
        14 to listOf("1-ne/11", "31", "36", "1-ne/12", "1", "10"),
        15 to listOf("1-ne/12", "11", "23", "1-ne/13", "1", "9"),
        16 to listOf("1-ne/13", "10", "27"),
        17 to listOf("1-ne/13", "28", "39"),
        18 to listOf("1-ne/13", "40", "42", "1-ne/14", "1", "8"),
        19 to listOf("1-ne/14", "9", "30"),
        20 to listOf("1-ne/15", "1", "18"),
        21 to listOf("1-ne/15", "19", "36"),
        22 to listOf("1-ne/16", "1", "16"),
        23 to listOf("1-ne/16", "17", "30"),
        24 to listOf("1-ne/17", "1", "16"),
        25 to listOf("1-ne/17", "17", "30"),
        26 to listOf("1-ne/17", "31", "47"),
        27 to listOf("1-ne/17", "48", "55", "1-ne/18", "1", "4"),
        28 to listOf("1-ne/18", "5", "20"),
        29 to listOf("1-ne/18", "21", "25", "1-ne/19", "1", "6"),
        30 to listOf("1-ne/19", "7", "24"),
        31 to listOf("1-ne/20", "1", "22")
    )
    private val february = mapOf(
        1 to listOf("1-ne/21", "1", "21"),
        2 to listOf("1-ne/21", "22", "26", "1-ne/22", "1", "10"),
        3 to listOf("1-ne/22", "11", "31"),
        4 to listOf("2-ne/1", "1", "12"),
        5 to listOf("2-ne/1", "13", "29"),
        6 to listOf("2-ne/1", "30", "32", "2-ne/2", "1", "10"),
        7 to listOf("2-ne/2", "11", "21"),
        8 to listOf("2-ne/2", "22", "30", "2-ne/3", "1", "5"),
        9 to listOf("2-ne/3", "6", "25"),
        10 to listOf("2-ne/4", "1", "27"),
        11 to listOf("2-ne/4", "28", "35", "2-ne/5", "1", "9"),
        12 to listOf("2-ne/5", "10", "25"),
        13 to listOf("2-ne/5", "26", "34", "2-ne/6", "1", "7"),
        14 to listOf("2-ne/6", "8", "18", "2-ne/7", "1", "11"),
        15 to listOf("2-ne/8", "1", "25"),
        16 to listOf("2-ne/9", "1", "14"),
        17 to listOf("2-ne/9", "15", "30"),
        18 to listOf("2-ne/9", "31", "49"),
        19 to listOf("2-ne/9", "50", "54", "2-ne/10", "1", "17"),
        20 to listOf("2-ne/10", "18", "25", "2-ne/11", "1", "8"),
        21 to listOf("2-ne/12", "1", "22", "2-ne/13", "1", "5"),
        22 to listOf("2-ne/13", "6", "26", "2-ne/14", "1", "6"),
        23 to listOf("2-ne/15", "1", "30"),
        24 to listOf("2-ne/16", "1", "13", "2-ne/17", "1", "25"),
        25 to listOf("2-ne/18", "1", "22"),
        26 to listOf("2-ne/19", "1", "21", "2-ne/20", "1", "11"),
        27 to listOf("2-ne/20", "12", "34"),
        28 to listOf("2-ne/21", "1", "16", "2-ne/22", "1", "6"),
        29 to listOf("alma/7", "11", "12")
    )
    private val march = mapOf(
        1 to listOf("2-ne/23", "1", "22"),
        2 to listOf("2-ne/24", "1", "32"),
        3 to listOf("2-ne/25", "1", "13"),
        4 to listOf("2-ne/25", "14", "26"),
        5 to listOf("2-ne/25", "27", "30", "2-ne/26", "1", "11"),
        6 to listOf("2-ne/26", "12", "30"),
        7 to listOf("2-ne/26", "31", "33", "2-ne/27", "1", "11"),
        8 to listOf("2-ne/27", "12", "35"),
        9 to listOf("2-ne/28", "1", "16"),
        10 to listOf("2-ne/28", "17", "32"),
        11 to listOf("2-ne/29", "1", "14"),
        12 to listOf("2-ne/30", "1", "18"),
        13 to listOf("2-ne/31", "1", "21"),
        14 to listOf("2-ne/32", "1", "9"),
        15 to listOf("2-ne/33", "1", "15"),
        16 to listOf("jacob/1", "1", "19"),
        17 to listOf("jacob/2", "1", "16"),
        18 to listOf("jacob/2", "17", "35"),
        19 to listOf("jacob/3", "1", "14"),
        20 to listOf("jacob/4", "1", "18"),
        21 to listOf("jacob/5", "1", "18"),
        22 to listOf("jacob/5", "19", "34"),
        23 to listOf("jacob/5", "35", "48"),
        24 to listOf("jacob/5", "49", "69"),
        25 to listOf("jacob/5", "70", "77"),
        26 to listOf("jacob/6", "1", "13", "jacob/7", "1", "5"),
        27 to listOf("jacob/7", "6", "27"),
        28 to listOf("enos/1", "1", "18"),
        29 to listOf("enos/1", "19", "27"),
        30 to listOf("jarom/1", "1", "15"),
        31 to listOf("omni/1", "1", "11")
    )
    private val april= mapOf(
        1 to listOf("omni/1", "12", "30"),
        2 to listOf("w-of-m/1", "1", "18"),
        3 to listOf("mosiah/1", "1", "14"),
        4 to listOf("mosiah/1", "15", "18", "mosiah/2", "1", "8"),
        5 to listOf("mosiah/2", "9", "27"),
        6 to listOf("mosiah/2", "28", "41"),
        7 to listOf("mosiah/3", "1", "18"),
        8 to listOf("mosiah/3", "19", "27", "mosiah/4", "1", "3"),
        9 to listOf("mosiah/4", "4", "15"),
        10 to listOf("mosiah/4", "16", "30"),
        11 to listOf("mosiah/5", "1", "15"),
        12 to listOf("mosiah/6", "1", "7", "mosiah/7", "1", "7"),
        13 to listOf("mosiah/7", "8", "17"),
        14 to listOf("mosiah/7", "18", "33"),
        15 to listOf("mosiah/8", "1", "21"),
        16 to listOf("mosiah/9", "1", "19"),
        17 to listOf("mosiah/10", "1", "22"),
        18 to listOf("mosiah/11", "1", "15"),
        19 to listOf("mosiah/11", "16", "29"),
        20 to listOf("mosiah/12", "1", "16"),
        21 to listOf("mosiah/12", "17", "37", "mosiah/13", "1", "4"),
        22 to listOf("mosiah/13", "5", "35"),
        23 to listOf("mosiah/14", "1", "12", "mosiah/15", "1", "9"),
        24 to listOf("mosiah/15", "10", "31"),
        25 to listOf("mosiah/16", "1", "15"),
        26 to listOf("mosiah/17", "1", "20"),
        27 to listOf("mosiah/18", "1", "16"),
        28 to listOf("mosiah/18", "17", "35"),
        29 to listOf("mosiah/19", "1", "24"),
        30 to listOf("mosiah/19", "25", "29", "mosiah/20", "1", "11")
    )
    private val may= mapOf(
        1 to listOf("mosiah/20", "12", "26", "mosiah/21", "1", "8"),
        2 to listOf("mosiah/21", "9", "27"),
        3 to listOf("mosiah/21", "28", "36", "mosiah/22", "1", "9"),
        4 to listOf("mosiah/22", "10", "16", "mosiah/23", "1", "15"),
        5 to listOf("mosiah/23", "16", "39"),
        6 to listOf("mosiah/24", "1", "15"),
        7 to listOf("mosiah/24", "16", "25", "mosiah/25", "1", "14"),
        8 to listOf("mosiah/25", "15", "24", "mosiah/26", "1", "13"),
        9 to listOf("mosiah/26", "14", "39"),
        10 to listOf("mosiah/27", "1", "17"),
        11 to listOf("mosiah/27", "18", "37"),
        12 to listOf("mosiah/28", "1", "10"),
        13 to listOf("mosiah/29", "1", "15"),
        14 to listOf("mosiah/29", "16", "32"),
        15 to listOf("mosiah/29", "33", "47"),
        16 to listOf("alma/1", "1", "14"),
        17 to listOf("alma/1", "15", "33"),
        18 to listOf("alma/2", "1", "18"),
        19 to listOf("alma/2", "19", "38"),
        20 to listOf("alma/3", "1", "19"),
        21 to listOf("alma/3", "20", "27", "alma/4", "1", "4"),
        22 to listOf("alma/4", "5", "20"),
        23 to listOf("alma/5", "1", "25"),
        24 to listOf("alma/5", "26", "42"),
        25 to listOf("alma/5", "43", "52"),
        26 to listOf("alma/5", "53", "62", "alma/6", "1", "8"),
        27 to listOf("alma/7", "1", "13"),
        28 to listOf("alma/7", "14", "27"),
        29 to listOf("alma/8", "1", "17"),
        30 to listOf("alma/8", "18", "32", "alma/9", "1", "6"),
        31 to listOf("alma/9", "7", "18")
    )
    private val june= mapOf(
        1 to listOf("alma/9", "19", "34"),
        2 to listOf("alma/10", "1", "16"),
        3 to listOf("alma/10", "17", "32"),
        4 to listOf("alma/11", "1", "20"),
        5 to listOf("alma/11", "11", "46"),
        6 to listOf("alma/12", "1", "19"),
        7 to listOf("alma/12", "20", "27"),
        8 to listOf("alma/12", "28", "37", "alma/13", "1", "9"),
        9 to listOf("alma/13", "10", "20"),
        10 to listOf("alma/13", "21", "31", "alma/14", "1", "5"),
        11 to listOf("alma/14", "6", "22"),
        12 to listOf("alma/14", "23", "29", "alma/15", "1", "12"),
        13 to listOf("alma/15", "13", "19", "alma/16", "1", "3"),
        14 to listOf("alma/16", "4", "21"),
        15 to listOf("alma/17", "1", "17"),
        16 to listOf("alma/17", "18", "31"),
        17 to listOf("alma/17", "32", "39", "alma/18", "1", "7"),
        18 to listOf("alma/18", "8", "23"),
        19 to listOf("alma/18", "24", "43", "alma/19", "1", "11"),
        20 to listOf("alma/19", "12", "21"),
        21 to listOf("alma/19", "22", "36"),
        22 to listOf("alma/20", "1", "18"),
        23 to listOf("alma/20", "19", "30", "alma/21", "1", "4"),
        24 to listOf("alma/21", "5", "23"),
        25 to listOf("alma/22", "1", "14"),
        26 to listOf("alma/22", "15", "26"),
        27 to listOf("alma/22", "27", "35", "alma/23", "1", "7"),
        28 to listOf("alma/23", "8", "18", "alma/24", "1", "6"),
        29 to listOf("alma/24", "7", "16"),
        30 to listOf("alma/24", "17", "30", "alma/25", "1", "6")
    )
    private val july= mapOf(
        1 to listOf("alma/25", "7", "17", "alma/26", "1", "9"),
        2 to listOf("alma/26", "10", "22"),
        3 to listOf("alma/26", "23", "37"),
        4 to listOf("alma/27", "1", "15"),
        5 to listOf("alma/27", "16", "30", "alma/28", "1", "8"),
        6 to listOf("alma/28", "9", "14", "alma/29", "1", "7"),
        7 to listOf("alma/29", "8", "17", "alma/30", "1", "11"),
        8 to listOf("alma/30", "12", "28"),
        9 to listOf("alma/30", "29", "49"),
        10 to listOf("alma/30", "50", "60"),
        11 to listOf("alma/31", "1", "23"),
        12 to listOf("alma/31", "24", "38"),
        13 to listOf("alma/32", "1", "20"),
        14 to listOf("alma/32", "21", "33"),
        15 to listOf("alma/32", "34", "43", "alma/33", "1", "11"),
        16 to listOf("alma/33", "12", "23"),
        17 to listOf("alma/34", "1", "16"),
        18 to listOf("alma/34", "17", "41"),
        19 to listOf("alma/35", "1", "16"),
        20 to listOf("alma/36", "1", "24"),
        21 to listOf("alma/36", "25", "30", "alma/37", "1", "10"),
        22 to listOf("alma/37", "11", "25"),
        23 to listOf("alma/37", "26", "42"),
        24 to listOf("alma/37", "43", "47", "alma/38", "1", "8"),
        25 to listOf("alma/38", "9", "15", "alma/39", "1", "8"),
        26 to listOf("alma/39", "9", "19", "alma/40", "1", "10"),
        27 to listOf("alma/40", "11", "26"),
        28 to listOf("alma/41", "1", "15"),
        29 to listOf("alma/42", "1", "25"),
        30 to listOf("alma/42", "26", "31", "alma/43", "1", "14"),
        31 to listOf("alma/43", "15", "26")
    )
    private val august= mapOf(
        1 to listOf("alma/43", "27", "40"),
        2 to listOf("alma/43", "41", "54"),
        3 to listOf("alma/44", "1", "15"),
        4 to listOf("alma/44", "16", "24", "alma/45", "1", "19"),
        5 to listOf("alma/45", "20", "24", "alma/46", "1", "10"),
        6 to listOf("alma/46", "11", "28"),
        7 to listOf("alma/46", "29", "41"),
        8 to listOf("alma/47", "1", "19"),
        9 to listOf("alma/47", "20", "36"),
        10 to listOf("alma/48", "1", "18"),
        11 to listOf("alma/48", "19", "25", "alma/49", "1", "8"),
        12 to listOf("alma/49", "9", "24"),
        13 to listOf("alma/49", "25", "30", "alma/50", "1", "12"),
        14 to listOf("alma/50", "13", "34"),
        15 to listOf("alma/50", "35", "40", "alma/51", "1", "12"),
        16 to listOf("alma/51", "13", "21"),
        17 to listOf("alma/51", "22", "37"),
        18 to listOf("alma/52", "1", "18"),
        19 to listOf("alma/52", "19", "40"),
        20 to listOf("alma/53", "1", "9"),
        21 to listOf("alma/53", "10", "23", "alma/54", "1", "14"),
        22 to listOf("alma/54", "15", "24", "alma/55", "1", "3"),
        23 to listOf("alma/55", "4", "27"),
        24 to listOf("alma/55", "28", "35", "alma/56", "1", "17"),
        25 to listOf("alma/56", "18", "38"),
        26 to listOf("alma/56", "39", "57"),
        27 to listOf("alma/57", "1", "16"),
        28 to listOf("alma/57", "17", "36"),
        29 to listOf("alma/58", "1", "12"),
        30 to listOf("alma/58", "13", "29"),
        31 to listOf("alma/58", "30", "41", "alma/59", "1", "13")
    )
    private val september= mapOf(
        1 to listOf("alma/60", "1", "13"),
        2 to listOf("alma/60", "14", "28"),
        3 to listOf("alma/60", "29", "36", "alma/61", "1", "5"),
        4 to listOf("alma/61", "6", "21"),
        5 to listOf("alma/62", "1", "18"),
        6 to listOf("alma/62", "19", "33"),
        7 to listOf("alma/62", "34", "52"),
        8 to listOf("alma/63", "1", "17"),
        9 to listOf("hel/1", "1", "17"),
        10 to listOf("hel/1", "18", "34"),
        11 to listOf("hel/2", "1", "14"),
        12 to listOf("hel/3", "1", "18"),
        13 to listOf("hel/3", "19", "37"),
        14 to listOf("hel/4", "1", "17"),
        15 to listOf("hel/4", "18", "26", "hel/5", "1", "4"),
        16 to listOf("hel/5", "5", "17"),
        17 to listOf("hel/5", "18", "45"),
        18 to listOf("hel/5", "46", "52", "hel/6", "1", "14"),
        19 to listOf("hel/6", "15", "30"),
        20 to listOf("hel/6", "31", "41"),
        21 to listOf("hel/7", "1", "12"),
        22 to listOf("hel/7", "13", "29", "hel/8", "1", "10"),
        23 to listOf("hel/8", "11", "28"),
        24 to listOf("hel/9", "1", "17"),
        25 to listOf("hel/9", "18", "41"),
        26 to listOf("hel/10", "1", "19"),
        27 to listOf("hel/11", "1", "20"),
        28 to listOf("hel/11", "21", "38"),
        29 to listOf("hel/12", "1", "17"),
        30 to listOf("hel/12", "18", "26", "hel/13", "1", "4")
    )
    private val october= mapOf(
        1 to listOf("hel/13", "5", "20"),
        2 to listOf("hel/13", "21", "39"),
        3 to listOf("hel/14", "1", "19"),
        4 to listOf("hel/14", "20", "31", "hel/15", "1", "6"),
        5 to listOf("hel/15", "7", "17", "hel/16", "1", "11"),
        6 to listOf("hel/16", "12", "25"),
        7 to listOf("3-ne/1", "1", "14"),
        8 to listOf("3-ne/1", "15", "30"),
        9 to listOf("3-ne/2", "1", "19"),
        10 to listOf("3-ne/3", "1", "10"),
        11 to listOf("3-ne/3", "11", "26"),
        12 to listOf("3-ne/4", "1", "14"),
        13 to listOf("3-ne/4", "15", "33"),
        14 to listOf("3-ne/5", "1", "19"),
        15 to listOf("3-ne/5", "20", "26", "3-ne/6", "1", "18"),
        16 to listOf("3-ne/6", "19", "30"),
        17 to listOf("3-ne/7", "1", "13"),
        18 to listOf("3-ne/7", "14", "26", "3-ne/8", "1", "4"),
        19 to listOf("3-ne/8", "5", "25"),
        20 to listOf("3-ne/9", "1", "22"),
        21 to listOf("3-ne/10", "1", "19"),
        22 to listOf("3-ne/11", "1", "17"),
        23 to listOf("3-ne/11", "18", "41"),
        24 to listOf("3-ne/12", "1", "20"),
        25 to listOf("3-ne/12", "21", "48", "3-ne/13", "1", "4"),
        26 to listOf("3-ne/13", "5", "34"),
        27 to listOf("3-ne/14", "1", "27"),
        28 to listOf("3-ne/15", "1", "24"),
        29 to listOf("3-ne/16", "1", "20"),
        30 to listOf("3-ne/17", "1", "20"),
        31 to listOf("3-ne/17", "21", "25", "3-ne/18", "1", "14")
    )
    private val november= mapOf(
        1 to listOf("3-ne/18", "15", "35"),
        2 to listOf("3-ne/18", "36", "39", "3-ne/19", "1", "14"),
        3 to listOf("3-ne/19", "15", "36"),
        4 to listOf("3-ne/20", "1", "22"),
        5 to listOf("3-ne/20", "23", "46"),
        6 to listOf("3-ne/21", "1", "29"),
        7 to listOf("3-ne/22", "1", "17"),
        8 to listOf("3-ne/23", "1", "14"),
        9 to listOf("3-ne/24", "1", "18", "3-ne/25", "1", "6"),
        10 to listOf("3-ne/26", "1", "21"),
        11 to listOf("3-ne/27", "1", "12"),
        12 to listOf("3-ne/27", "13", "33"),
        13 to listOf("3-ne/28", "1", "24"),
        14 to listOf("3-ne/28", "25", "40"),
        15 to listOf("3-ne/29", "1", "9", "3-ne/30", "1", "2"),
        16 to listOf("4-ne/1", "1", "22"),
        17 to listOf("4-ne/1", "23", "49"),
        18 to listOf("morm/1", "1", "19"),
        19 to listOf("morm/2", "1", "16"),
        20 to listOf("morm/2", "17", "29"),
        21 to listOf("morm/3", "1", "22"),
        22 to listOf("morm/4", "1", "22"),
        23 to listOf("morm/5", "1", "12"),
        24 to listOf("morm/5", "13", "24", "morm/6", "1", "5"),
        25 to listOf("morm/6", "6", "22"),
        26 to listOf("morm/7", "1", "10", "morm/8", "1", "11"),
        27 to listOf("morm/8", "12", "25"),
        28 to listOf("morm/8", "26", "41"),
        29 to listOf("morm/9", "1", "21"),
        30 to listOf("morm/9", "22", "37")
    )
    private val december= mapOf(
        1 to listOf("ether/1", "1", "43"),
        2 to listOf("ether/2", "1", "12"),
        3 to listOf("ether/2", "13", "25"),
        4 to listOf("ether/3", "1", "16"),
        5 to listOf("ether/3", "17", "28"),
        6 to listOf("ether/4", "1", "19"),
        7 to listOf("ether/5", "1", "6", "ether/6", "1", "11"),
        8 to listOf("ether/6", "12", "30", "ether/7", "1", "6"),
        9 to listOf("ether/7", "7", "27"),
        10 to listOf("ether/8", "1", "17"),
        11 to listOf("ether/8", "18", "26"),
        12 to listOf("ether/9", "1", "22"),
        13 to listOf("ether/9", "23", "35"),
        14 to listOf("ether/10", "1", "14"),
        15 to listOf("ether/10", "15", "34"),
        16 to listOf("ether/11", "1", "23"),
        17 to listOf("ether/12", "1", "21"),
        18 to listOf("ether/12", "22", "41"),
        19 to listOf("ether/13", "1", "18"),
        20 to listOf("ether/13", "19", "31", "ether/14", "1", "7"),
        21 to listOf("ether/14", "8", "31"),
        22 to listOf("ether/15", "1", "17"),
        23 to listOf("ether/15", "18", "34"),
        24 to listOf("moro/1", "1", "4", "moro/2", "1", "3", "moro/3", "1", "4", "moro/4", "1", "3", "moro/5", "1", "2"),
        25 to listOf("moro/6", "1", "9", "moro/7", "1", "19"),
        26 to listOf("moro/7", "20", "34"),
        27 to listOf("moro/7", "35", "48"),
        28 to listOf("moro/8", "1", "26"),
        29 to listOf("moro/8", "27", "30", "moro/9", "1", "19"),
        30 to listOf("moro/9", "20", "26", "moro/10", "1", "7"),
        31 to listOf("moro/10", "8", "34")



    )


    val months = mapOf(
        Calendar.JANUARY to january,
        Calendar.FEBRUARY to february,
        Calendar.MARCH to march,
        Calendar.APRIL to april,
        Calendar.MAY to may,
        Calendar.JUNE to june,
        Calendar.JULY to july,
        Calendar.AUGUST to august,
        Calendar.SEPTEMBER to september,
        Calendar.OCTOBER to october,
        Calendar.NOVEMBER to november,
        Calendar.DECEMBER to december
    )

}