package timeouts

import kotlinx.coroutines.experimental.*
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    mainyTime(args)
}

fun mainyTime(args: Array<String>) = runBlocking {

    launch {

        withTimeout(2, TimeUnit.SECONDS) {

            for (i in 0..100) {
                println("index $i")
                delay(100)
            }
        }
    }
}

suspend fun printHello() {
    println("Hello 2")
}