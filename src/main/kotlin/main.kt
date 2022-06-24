const val USER_1 = "Alex"
const val USER_2 = "Oleg"
const val USER_3 = "Masha"
const val USER_4 = "Kotlin"
const val USER_5 = "Alexandr"
const val USER_6 = "777"

fun main() {
    println(agoToText(52))
    println(agoToText(3200))
    println(agoToText(60200))
    println(agoToText(124500))
    println(agoToText(250100))
    println(agoToText(500000))
}

fun agoToText(secondsAgo: Int): String {
    return when (secondsAgo) {
        in 0..60 -> "$USER_1 был(а) только что"
        in 61..3600 -> "$USER_2 был(а) " + minutesText(secondsAgo)
        in 3601..86400 -> "$USER_3 был(а) " + hoursText(secondsAgo)
        in 86401..172800 -> "$USER_4 был(а) сегодня"
        in 172801..259200 -> "$USER_5 был(а) вчера"
        else -> "$USER_6 был(а) давно"
    }
}

fun minutesText(secondsAgo: Int): String {
    var minutes = secondsAgo / 60
    var remainsOfMinutes = minutes % 10
    return when {
        remainsOfMinutes == 1 && minutes != 11 -> "$minutes минуту назад"
        minutes in 11..14 -> "$minutes минут назад"
        remainsOfMinutes in 2..4 -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}

fun hoursText(secondsAgo: Int): String {
    var hours = secondsAgo / 3600
    var remainsOfHours = hours % 10
    return when {
        remainsOfHours == 1 && hours != 11 -> "$hours час назад"
        hours in 10..20 -> "$hours часов назад"
        remainsOfHours in 2..4 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}