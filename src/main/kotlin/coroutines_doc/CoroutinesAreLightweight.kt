package coroutines_doc

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking{

    repeat(100_000) {
        launch {
            delay(5_000L)
            print(".")
        }
    }

}