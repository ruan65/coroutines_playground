package coroutines_doc

import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking{

    GlobalScope.launch {
        repeat(1000) {i ->

            println("I'm sleeping $i ...")
            delay(500)

        }
    }

    delay(1501L)
}