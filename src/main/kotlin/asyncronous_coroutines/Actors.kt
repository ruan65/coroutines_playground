package asyncronous_coroutines

import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.actor
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.util.*

fun main(args: Array<String>) {
    mainyActors(args)
}

fun mainyActors(args: Array<String>) = runBlocking {


    val actorPrinter = actor<Int>(coroutineContext) {
        for (i in channel) {
            println(i)
        }
    }
    actorPrinter
}