package ru.skillbranch.devintensive.extensions

fun String.truncate(value: Int = 16):String {
    return if (this.trim().length<=value) {this.trim()}
    else {
     this.trim().slice(0 until value).plus("...") }
}

fun String.stripHtml(): String {
    return this.replace("<[^>]*>|[&<>'\"]".toRegex(), "").replace("\\s+".toRegex(), " ")
}