fun main() {
    val time = agoToText(3600)
    println(time)
}

fun agoToText(userTimeInSeconds: Int) = when (userTimeInSeconds) {
    in 0..60 -> "Только что"
    in 61..60 * 60 -> timeForMinute(userTimeInSeconds)
    in 60 * 60 + 1..24 * 60 * 60 -> timeForHour(userTimeInSeconds)
    in 24 * 60 * 60 + 1..48 * 60 * 60 -> "был(а) вчера"
    in 48 * 60 * 60 + 1..72 * 60 * 60 -> "был(а) позавчера"
    else -> "был(а) давно"
}

fun timeForMinute(userTimeInSeconds: Int, t: Int = userTimeInSeconds/60) = when(t) {
    1,21,31,41,51 -> "был(а) $t минуту назад"
    2,22,32,42,52 -> "был(а) $t минуты назад"
    3,23,33,43,53 -> "был(а) $t минуты назад"
    4,24,34,44,54 -> "был(а) $t минуты назад"
    60 -> "был(а) 1 час назад"
    else -> "был(а) $t минут назад"
}

fun timeForHour(userTimeInSeconds: Int, t: Int = userTimeInSeconds/(60 * 60)) = when(t) {
    1,21 -> "был(а) $t час назад"
    2,3,4,22,23,24 -> "был(а) $t часа назад"
    else -> "был(а) $t часов назад"
}
