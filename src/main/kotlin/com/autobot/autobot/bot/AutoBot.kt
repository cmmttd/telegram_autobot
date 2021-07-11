package com.autobot.autobot.bot

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.entities.ChatId
import org.springframework.stereotype.Service

@Service
class AutoBot {

    var envToken: String = System.getenv("BOT_TOKEN_AUTO") ?: "1433373221:AAEz9HoH-IoDyXNGcz1yR0ibgZZnST8vJrU"

    fun run() {
        println("bot started")
        bot {
            token = envToken
            dispatch {
                command("test") {
                    bot.sendMessage(ChatId.fromId(message.chat.id), "test")
                }
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