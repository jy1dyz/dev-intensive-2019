package ru.skillbranch.devintensive.extensions

import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60* SECOND
const val HOUR = 60* MINUTE
const val DAY  = 24* HOUR

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND) :Date {
    var time = this.time

    time +=when(units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY

     }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {
    TODO("not implemented")
    /*

        var newSec: Int = ((Date().time - this.time) / 1000).toInt()
        val isFuture:Boolean

        isFuture = newSec <= 0
        newSec = abs(newSec)

        if(isFuture){
            when{
                newSec < 60  -> return getLastText(
                        number = newSec,
                        oneFormat = "через %d секунду",
                        fewFormat = "через %d секунды",
                        manyFormat = "через %d секунд"
                )
                toMinutes(newSec) < 60  -> return getLastText(
                        number =  toMinutes(newSec),
                        oneFormat = "через %d минуту",
                        fewFormat = "через %d минуты",
                        manyFormat = "через %d минут"
                )
                toHours(newSec) < 24  -> return getLastText(
                        number = toHours(newSec),
                        oneFormat = "через %d час",
                        fewFormat = "через %d часа",
                        manyFormat = "через %d часов"
                )
                else ->
                    return getLastText(
                            number = toDays(newSec),
                            oneFormat = "через %d день",
                            fewFormat = "через %d дня",
                            manyFormat = "через %d дней")
            }
        }
        else{
            when{
                newSec == 0 || newSec == 1 -> {
                    return "только что"
                }
                newSec in 1..45 -> return "несколько секунд назад"

                newSec in 45..75 -> return "минуту назад"

                toMinutes(newSec) < 45  -> return getLastText(
                        number =  toMinutes(newSec),
                        oneFormat = "%d минуту назад",
                        fewFormat = "%d минуты назад",
                        manyFormat = "%d минут назад"
                )

                toMinutes(newSec) in 45..75 -> return "час назад"

                toHours(newSec) < 22  -> return getLastText(
                        number = toHours(newSec),
                        oneFormat = "%d час назад",
                        fewFormat = "%d часа назад",
                        manyFormat = "%d часов назад"
                )

                toHours(newSec) in 22..26 -> return "день назад"
                toHours(newSec) > 26 && toDays(newSec) < 360 -> return getLastText(
                        number = toDays(newSec),
                        oneFormat = "%d день назад",
                        fewFormat = "%d дня назад",
                        manyFormat = "%d дней назад")

                else ->
                    return "более года назад"
            }
        }
    }

    private fun toDays(newSec: Int) = newSec / 86400
    private fun toHours(newSec: Int) = newSec / 3600
    private fun toMinutes(newSec: Int) = newSec / 60

    fun getLastText(number: Int, oneFormat: String, fewFormat: String, manyFormat: String):String {
        return when{
            number % 100 in 11..19 -> manyFormat.format(number)
            number % 10 == 1 -> oneFormat.format(number)
            number % 10 in 2..4 -> fewFormat.format(number)
            else -> manyFormat.format(number)
        } */
    }



enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY,
}