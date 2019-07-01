package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)


        if ("$fullName".isBlank()) return Pair(null, null)
        return Pair(firstName, lastName)
        //return firstName to lastName

    }

    fun transliteration(payload: String, divider: String = " "): String {
        /*val translit: HashMap<String, String> = hashMapOf(
            "а" to "a",
            "б" to "b",
            "в" to "v",
            "ґ" to "g",
            "г" to "g",
            "д" to "d",
            "е" to "e",
            "ё" to "e",
            "є" to "ye",
            "ж" to "zh",
            "з" to "z",
            "и" to "i",
            "і" to "i",
            "ї" to "yi",
            "й" to "i",
            "к" to "k",
            "л" to "l",
            "м" to "m",
            "н" to "n",
            "о" to "o",
            "п" to "p",
            "р" to "r",
            "с" to "s",
            "т" to "t",
            "у" to "u",
            "ф" to "f",
            "х" to "h",
            "ц" to "c",
            "ч" to "ch",
            "ш" to "sh",
            "щ" to "sh'",
            "ъ" to "",
            "ы" to "i",
            "ь" to "",
            "э" to "e",
            "ю" to "yu",
            "я" to "ya"

        )
        val typing: List<String>? = payload.split(" ")
        val typing2 = StringBuilder(typing?.get(0)+divider+ typing?.get(1))
        println(typing2.toString())
        val newTyping = typing2.map { if(it.isUpperCase()) translit[it.toString().toLowerCase()]?.
            toUpperCase() else translit[it.toString()]
        }
        val new = StringBuilder()
        newTyping.forEach{new.append(it)}
        return new.toString() */
        return payload.replace(" ", divider)
                .replace("А", "A")
                .replace("Б", "B")
                .replace("В", "V")
                .replace("Г", "G")
                .replace("Д", "D")
                .replace("Е", "E")
                .replace("Ё", "E")
                .replace("Ж", "ZH")
                .replace("З", "Z")
                .replace("И", "I")
                .replace("Й", "I")
                .replace("К", "K")
                .replace("Л", "L")
                .replace("М", "M")
                .replace("Н", "N")
                .replace("О", "O")
                .replace("П", "P")
                .replace("Р", "R")
                .replace("С", "S")
                .replace("Т", "T")
                .replace("У", "U")
                .replace("Ф", "F")
                .replace("Х", "H")
                .replace("Ц", "C")
                .replace("Ч", "CH")
                .replace("Ш", "SH")
                .replace("Щ", "SH")
                .replace("Ъ", "")
                .replace("Ы", "I")
                .replace("Ь", "")
                .replace("Э", "E")
                .replace("Ю", "YU")
                .replace("Я", "YA")
                .replace("а", "a")
                .replace("б", "b")
                .replace("в", "v")
                .replace("г", "g")
                .replace("д", "d")
                .replace("е", "e")
                .replace("ё", "e")
                .replace("ж", "zh")
                .replace("з", "z")
                .replace("и", "i")
                .replace("й", "i")
                .replace("к", "k")
                .replace("л", "l")
                .replace("м", "m")
                .replace("н", "n")
                .replace("о", "o")
                .replace("п", "p")
                .replace("р", "r")
                .replace("с", "s")
                .replace("т", "t")
                .replace("у", "u")
                .replace("ф", "f")
                .replace("х", "h")
                .replace("ц", "c")
                .replace("ч", "ch")
                .replace("ш", "sh")
                .replace("щ", "sh")
                .replace("ъ", "")
                .replace("ы", "i")
                .replace("ь", "")
                .replace("э", "e")
                .replace("ю", "yu")
                .replace("я", "ya")


    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        val str = StringBuilder()

        when {
            firstName.isNullOrBlank() -> {}
            firstName.isNullOrEmpty() -> {}
            else -> str.append("$firstName".substring(0, 1).capitalize())
        }

        when {
            lastName.isNullOrBlank() -> {}
            lastName.isNullOrEmpty() -> {}
            else -> str.append("$lastName".substring(0, 1).capitalize())
        }
        return if (str.isEmpty())
            null
        else
            str.toString()

    }
}


