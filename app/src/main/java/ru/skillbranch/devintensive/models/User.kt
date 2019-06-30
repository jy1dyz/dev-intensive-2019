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

