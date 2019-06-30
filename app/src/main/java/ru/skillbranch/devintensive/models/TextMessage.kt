package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
import java.util.*

class TextMessage(
    id:String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var text:String?
)    : BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessage(): String = "id:$id ${from?.firstName} ${if(isIncoming) 
        "получил" else "отправил"} сообщение \"$text\" $date"
    }

