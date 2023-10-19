import kotlin.random.Random

var time: String = (Random.nextInt(0, 1_000_000)).toString()

fun main() {
    println(agoToText(time))
}

fun minutes(): String {
    var min = "timeAgo"

    if (time.length == 2 && time[(time.length) - 2] == '1') {
        min = "${time.toInt() / 60} минут"
    } else if (time[(time.length) - 1] == '1') {
        min = "${time.toInt() / 60} минуту"
    } else if (time[(time.length) - 1] == '2' || time[(time.length) - 1] == '3' || time[(time.length) - 1] == '4') {
        min = "${time.toInt() / 60} минуты"
    } else {
        min = "${time.toInt() / 60} минут"
    }
    return min
}

fun clock(): String {
    var hours = "timeAgo"
    if (time.length == 2 && time[(time.length) - 2] == '1') {
        hours = "${time.toInt() / 3600} часов"
    } else if (time[(time.length) - 1] == '1') {
        hours = "${time.toInt() / 3600} час"
    } else if (time[(time.length) - 1] == '2' || time[(time.length) - 1] == '3' || time[(time.length) - 1] == '4') {
        hours = "${time.toInt() / 3600} часа"
    } else {
        hours = "${time.toInt() / 3600} часов"
    }
    return hours
}

fun agoToText(time: String): String {
    return when (time.toInt()) {
        in 0..60 -> "был(а) в сети только что"
        in 61..60 * 60 -> "был(а) в сети ${minutes()} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> "был(а) в сети ${clock()} назад"
        in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> "был(а) в сети вчера"
        in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> "был(а) в сети позавчера"
        else -> "был(а) в сети давно"
    }
}

