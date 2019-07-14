package ru.skillbranch.devintensive.models


class Bender(var status:Status = Status.NORMAL, var question:Question = Question.NAME){

    fun askQuestion():String = when (question){
                Question.NAME -> Question.NAME.question
                Question.PROFESSION -> Question.PROFESSION.question
                Question.MATERIAL -> Question.MATERIAL.question
                Question.BDAY -> Question.BDAY.question
                Question.SERIAL -> Question.SERIAL.question
                Question.IDLE  -> Question.IDLE.question

}
    fun listenAnswer(answer:String):Pair<String, Triple<Int,Int, Int>> {

        return when(question) {
            Question.IDLE -> question.question to status.color
            else -> "${checkAnswer(answer)}\n${question.question}" to status.color
        }
    }

    private fun checkAnswer(answer: String):String {
        return if(question.answers.contains(answer)) {
            question = question.nextQuestion()
            "Отлично - ты справился"
        }
        else if(status==Status.CRITICAL)
             {
                resetStates()
                "Это неправильный ответ. Давай все по новой"
            }
        else {
            status = status.nextStatus()
            "Это неправильный ответ"
        }
    }

    private fun resetStates() {
        status = Status.NORMAL
        question = Question.NAME
    }


    /*val valid = question.validate(answer)
    if(valid != null) {
        return (valid + question.question) to status.color
    }
    if(question.answers.contains(answer)) {
        question = question.nextQuestion()
        return "Отлично - ты справился!\n${question.question}" to status.color
    }
    status = status.nextStatus()
    val qed = if(status.ordinal != 0) {
        "Это неправильный ответ\n"+ question.question
    } else {
        question = Question.NAME
        "Это неправильный ответ. Давай все по новой\n" + question.question
    }
    return qed to status.color
*/



    enum class Status(val color:Triple<Int, Int, Int>) {
        NORMAL(Triple(255,255,255)),
        WARNING(Triple(255,120,0)),
        DANGER(Triple(255,60,60)),
        CRITICAL(Triple(255,0,0));

        fun nextStatus(): Status {
            return if(this.ordinal < values().lastIndex) {
                values()[this.ordinal + 1]
            } else {
                values()[0]
            }
        }
    }

    enum class Question(val question:String, val answers:List<String>, val mistakes:String?) {
        NAME("Как меня зовут?", listOf("бендер", "bender"), "Имя должно начинаться с заглавной буквы") {
            override fun nextQuestion(): Question = PROFESSION
            override fun validate(answer: String):Boolean = answer.trim().firstOrNull()?.isUpperCase() ?: false
        },
        PROFESSION("Назови мою профессию?", listOf("сгибальщик", "bender"), "Профессия должна начинаться со строчной буквы") {
            override fun nextQuestion(): Question = MATERIAL
            override fun validate(answer: String): Boolean = answer.trim().firstOrNull()?.isLowerCase() ?: false
        },
        MATERIAL("Из чего я сделан?", listOf("металл", "дерево", "iron", "wood"), "Материал не должен содержать цифр") {
            override fun nextQuestion(): Question = BDAY
            override fun validate(answer: String): Boolean = answer.trim().contains(Regex("\\d")).not()
        },
        BDAY("Когда меня создали?", listOf("2993"), "Год моего рождения должен содержать только цифры") {
            override fun nextQuestion(): Question = SERIAL
            override fun validate(answer: String): Boolean = answer.trim().contains(Regex("^[0-9]*$"))
        },
        SERIAL("Мой серийный номер?", listOf("2716057"), "Серийный номер содержит только цифры, и их 7") {
            override fun nextQuestion(): Question = IDLE
            override fun validate(answer: String): Boolean = answer.trim().contains(Regex("[0-9]{7}$"))
        },
        IDLE("На этом все, вопросов больше нет", listOf(), null) {
            override fun nextQuestion(): Question = IDLE
            override fun validate(answer: String): Boolean = true
        };

        abstract fun nextQuestion():Question
        abstract fun validate(answer: String):Boolean

        }

    }




