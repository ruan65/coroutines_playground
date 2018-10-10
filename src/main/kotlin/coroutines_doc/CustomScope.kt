package coroutines_doc

import kotlinx.coroutines.experimental.coroutineScope
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking<Unit>{

    launch {
        delay(700)
        println("Task from run blocking!")
    }

    coroutineScope {

        launch {
            delay(500)
            println("task from nested scope")
        }

        delay(100)
        println("Task from coroutine scope")
    }

    println("Coroutine scope is over ((")
}