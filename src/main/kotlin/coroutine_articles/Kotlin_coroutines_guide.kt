package coroutine_articles

import kotlinx.coroutines.experimental.coroutineScope
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

// https://kotlinexpertise.com/kotlin-coroutines-guide/

//fun main(args: Array<String>) {
//
//
//    runBlocking {
//        launch {
//            delay(1000)
//            println("Hello from launch!!!")
//        }
//        println("Hi from run blocking after launch")
//    }
//
//    println("Main is finished????")
//}

fun main(args: Array<String>) = runBlocking {

    coroutineScope {
        val outerLaunch = launch {
            launch {
                while (true) {
                    delay(300)
                    println("Hello from first inner launch")
                }
            }

            launch {
                while (true) {
                    delay(300)
                    println("Hello from second inner launch")
                }
            }
        }
        println("Hello from run blocking after outer launch")

        delay(800)

        outerLaunch.cancel()
    }
    println("Finished coroutine scope yeesssssy")
}