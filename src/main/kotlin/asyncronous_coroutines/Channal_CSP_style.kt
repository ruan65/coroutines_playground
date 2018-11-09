package asyncronous_coroutines

import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.util.*

fun main(args: Array<String>) {
    mainy(args)
}

fun mainy(args: Array<String>) = runBlocking {

    val channel = Channel<Int>()

    val random = Random()

    launch(coroutineContext) {
        repeat(10) {
            val time = random.nextInt(1000) + 100
            delay(time)
            channel.send(time)
        }
        channel.close()
    }

    launch(coroutineContext) {

        for (i in channel) {
            println(i)
        }
    }
}