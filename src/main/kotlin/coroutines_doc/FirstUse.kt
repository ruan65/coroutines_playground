package coroutines_doc

import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {

    GlobalScope.launch {
        delay(1000)
        print("World!")
    }

    print("Hello, ")
    runBlocking {
        delay(2000)
    }
}