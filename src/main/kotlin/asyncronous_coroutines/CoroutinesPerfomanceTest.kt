package asyncronous_coroutines

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main_(args: Array<String>) =

        runBlocking<Unit> {

            val start = System.currentTimeMillis()

            val jobs: List<Job> = List(SIZE) {
                launch {
                    delay(TIMEOUT)
                    print("*")
                }
            }
            jobs.forEach { it.join() }

            println()
            println("time millis: ${System.currentTimeMillis() - start}")
        }
