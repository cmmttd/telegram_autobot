package com.autobot.autobot

import com.autobot.autobot.bot.AutoBot
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AutobotApplication

fun main(args: Array<String>) {
    runApplication<AutobotApplication>(*args)
    AutoBot().run()
}
