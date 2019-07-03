package ru.skillbranch.devintensive.extensions

fun String.truncate(value: Int = 16):String {
    return this.substring(0, this.length.coerceAtMost(value + 1)).trim() + "..."
}

fun String.stripHtml(): String {
    return this.replace("<[^>]*>|[&<>'\"]".toRegex(), "").replace("\\s+".toRegex(), " ")
}