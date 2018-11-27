package coroutines_doc

import kotlinx.coroutines.experimental.cancelAndJoin
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking<Unit>{

    val job = launch {
        repeat(1000) {
            println("I am repeating: $it")
            delay(500)
        }
    }

    delay(1300)
    println("I'm tired of waiting....")
//    job.cancel()
//    job.join()

    job.cancelAndJoin()


    println("Now I am quit!")

}