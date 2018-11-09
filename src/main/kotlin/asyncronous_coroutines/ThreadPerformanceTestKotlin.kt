package asyncronous_coroutines

import java.util.concurrent.CountDownLatch
import kotlin.concurrent.thread

fun main__(args: Array<String>) {

    val start = System.currentTimeMillis()
    val countDownLatch = CountDownLatch(SIZE)

    val jobs = List(SIZE) {
        thread {
            Thread.sleep(TIMEOUT)
            print(".")
            countDownLatch.countDown()
        }
    }
    jobs.forEach {
        it.join()
    }

    countDownLatch.await()
    println()
    println("time millis: ${System.currentTimeMillis() - start}")
}