package syncronous

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.newSingleThreadContext
import kotlinx.coroutines.experimental.runBlocking

private fun myHeavyFunction() {
    println("Thread runnig: ${Thread.currentThread().name}")
}

val singleThreadDispatcher = newSingleThreadContext("singleThreadDispatcher__")

fun <T> singleThreadAsync(block: () -> T) : Job = launch(singleThreadDispatcher) {
    block.invoke()
}

fun main(args: Array<String>) {

    runBlocking {
        val job = launch {
            myHeavyFunction()
        }

        singleThreadAsync { myHeavyFunction() }
    }



}