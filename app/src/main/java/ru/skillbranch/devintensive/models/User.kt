package ru.skillbranch.devintensive.models

import java.util.*

data class User( //первичный конструктор
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = Date(),
    val isOnline: Boolean = false
) {
    //var introBit: String

    //вторичный конструктор
    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    //второй вторичный конструктор
    constructor(id: String) : this(id, "John", "Doe")

    //блок инициализации
    init {

        //introBit = getIntro()
        println("It's Alive!!! \n${if(lastName==="Doe")
                "His name id $firstName $lastName" else "And his name is $firstName $lastName" }\n")
        //println( "${getIntro()}")
    }

    /* private fun getIntro()="""
        tu tu tut tu ttuuuuu
        tu tu tu tuuuuuuu!!!
        
         tu tu tut tu ttuuuuu
        tu tu tu tuuuuuuu!!!
        ${"\n\n\n"}
        $firstName $lastName 
        
    """.trimIndent() */

    /*fun printMe() =
        println("""
            id: = $id: 
            firstName: = $firstName: 
            lastName: = $lastName: 
            avatar: = $avatar: 
            rating: = $rating: 
            respect: = $respect: 
            lastVisit: = $lastVisit: 
            isOnline: = $isOnline: 
        """.trimIndent()) */

    class Builder{
        private var id:String = ""
        private var firstName:String? = ""
        private var lastName: String? = ""
        private var avatar: String? = ""
        private var rating: Int = 0
        private var respect: Int = 0
        private var lastVisit: Date? = Date()
        private var isOnline: Boolean = false

        fun id(id:String) = apply{this.id = id}
        fun firstName(firstName: String?) = apply{this.firstName = firstName}
        fun lastName(lastName: String?) = apply{this.lastName = lastName}
        fun avatar(avatar: String?) = apply{this.avatar = avatar}
        fun rating(rating: Int) = apply{this.rating = rating}
        fun respect(respect: Int) = apply{this.respect = respect}
        fun lastVisit(lastVisit:Date) = apply{this.lastVisit = lastVisit}
        fun isOnline(isOnline:Boolean) = apply{this.isOnline = isOnline}


        fun build(): User{
            return User(id,firstName,lastName,avatar,rating,respect,lastVisit,isOnline)
        }

    }
    companion object Factory {
        private var lastId:Int = -1
        fun makeUser(fullName:String?): User {
            lastId++


            val parts: List<String>? = fullName?.split(" ")

            val firstName = parts?.getOrNull(0)
            val lastName = parts?.getOrNull(1)
            //val (firstName, lastName) = Utils.parseFullName(fullName)

            if("$fullName".isBlank()) return  User("$lastId", null, null)
            return User(id = "$lastId", firstName = firstName, lastName = lastName)

        }

    }
}


