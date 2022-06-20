fun main() {
    //переменная  времени остутствия в сети, сек
    val times = 50

    fun agoToText(time: Int): String {
        var minutes = time / 60
        var hours = time / 3600
        var timeText = when (time) {
            in 0..60 -> "только что"
            in 61..3_600 -> when {
                (minutes % 10 == 1 && minutes != 11) -> (minutes).toString() + " минуту назад"
                (minutes % 20 == 2 || minutes % 20 == 3 || minutes % 20 == 4) ->
                    (time / 60).toString() + " минуты назад"
                else -> minutes.toString() + " минут назад"
            }
            in 3601..86_400 -> when (hours) {
                1,21 -> hours.toString() + " час назад"
                2,3,4,22,23,24 -> hours.toString() + " часа назад"
                else -> hours.toString() + " часов назад"
            }
            in 86_401..172_800 -> "сегодня"
            in 172_801..259_200 -> "вчера"
            else -> "давно"
        }
        return "Пользователь был в сети $timeText"
    }
    fun hoursAgo(time: Int): String {
        var hours = when (time) {
            1,21 -> "час"
            2,3,4,22,23,24 -> "часа"
            else -> "часов"
        }
        return hours
    }
    //запуск функции с аргументом по времени отсутствия
    println(agoToText(times))


}