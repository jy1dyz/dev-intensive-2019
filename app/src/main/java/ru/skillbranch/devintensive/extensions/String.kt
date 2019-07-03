package ru.skillbranch.devintensive.extensions

fun String.truncate(length: Int = 16): String {
    return this.substring(0, this.trim().length.coerceAtMost(length + 1)).plus("...")
}

fun String.stripHtml(): String {
    return this.replace("<[^>]*>|[&<>'\"]".toRegex(), "").replace("\\s+".toRegex(), " ")
}