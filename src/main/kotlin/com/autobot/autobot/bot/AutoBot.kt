package com.autobot.autobot.bot

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.entities.ChatId
import org.springframework.stereotype.Service

@Service
class AutoBot {

    fun run() {
        println("bot started")
        val bot = bot {
            token = "1433373221:AAEz9HoH-IoDyXNGcz1yR0ibgZZnST8vJrU"
            dispatch {
                message {
                    val chatId = ChatId.fromId(message.chat.id)
                    val from = update.message?.from
                    println("get request from $chatId ${from?.firstName} ${from?.lastName} ${from?.username}")
                    while (message.text != "ss") {
                        bot.sendSticker(
                            chatId,
                            sticker = "CAACAgIAAxkBAAIFMWDkuMFLTW9tofMsvU1mFgWVqFiWAAJPCgACKg5YSwhPSXtwZXKAIAQ",
                            replyMarkup = null
                        )
                    }
                }
            }
        }.also {
            it.startPolling()
        }
    }
}