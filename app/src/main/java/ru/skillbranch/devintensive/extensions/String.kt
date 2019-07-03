package ru.skillbranch.devintensive.extensions

fun String.truncate(length: Int = 16):String {
    return if (this.trim().length<=length) {this.trim()}
    else {
     this.slice(0 until length).trim().plus("...") }
}

fun String.stripHtml(): String {
    return this.replace("<[^>]*>|[&<>'\"]".toRegex(), "").replace("\\s+".toRegex(), " ")
}