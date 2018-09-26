package syncronous

import kotlin.concurrent.thread

fun main(args: Array<String>) {

    val start = System.currentTimeMillis()

    val jobs = List(SIZE) {
        thread {
            Thread.sleep(1000L)
            print(".")
        }
    }
    jobs.forEach {
        it.join()
    }

    println()
    println("time millis: ${System.currentTimeMillis() - start}")
}