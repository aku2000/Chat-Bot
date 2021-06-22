package com.example.zenchi.utils

import com.example.zenchi.utils.Constants.OPEN_GOOGLE
import com.example.zenchi.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "Zenchi flipped a coin and it landed on $result"
            }

            //Math calculations
            message.contains("solve") -> {
                val equation: String? = message.substringAfterLast("solve")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Too complicated for me to solve... Try using a calculator xD"
                }
            }

            //Hello
            (message.contains("hello") || message.contains("hi") || message.contains("hey"))-> {
                when (random) {
                    0 -> "Hello there!How are you doing today?"
                    1 -> "Sssssup?"
                    2 -> "Guten Tag!"
                    else -> "error" }
            }

            //Bye
            (message.contains("bye") || message.contains("gnsd") || message.contains("night"))-> {
                when (random) {
                    0 -> "Gn! ZENCHI is going to sleep !!"
                    1 -> "Tschüss!! Take care!"
                    2 -> "Adios!"
                    else -> "error" }
            }

            //corona
            (message.contains("corona") || message.contains("tip") || message.contains("tips"))-> {
                when (random) {
                    0 -> "Wear masks!!"
                    1 -> "Get vaccinated"
                    2 -> "Please maintain 6ft distance from Zenchi!!!"
                    else -> "error" }
            }

            //How are you?
            message.contains("how are you") -> {
                when (random) {
                    0 -> "I'm doing fine, thanks buddy!"
                    1 -> "I'm hungry... I want Taco :("
                    2 -> "Pretty good! What about you?"
                    else -> "error"
                }
            }

            //What time is it?
            message.contains("time") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Open Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }

            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "Sorry...I don't understand..."
                    1 -> "Try asking me something else !!"
                    2 -> "Hey,Zenchi doesn't understand you.. Try asking Alexa xD"
                    else -> "error"
                }
            }
        }
    }
}