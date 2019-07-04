package ru.skillbranch.devintensive.extensions

fun String.truncate(value: Int = 16):String {
    return if(this.trim().length > value){
        this.substring(0,value).trim() + "..."
    } else{
        this.trim()
    }
}

fun String.stripHtml(): String {
    return this.replace("<[^>]*>|[&<>'\"]".toRegex(), "").replace("\\s+".toRegex(), " ")
}