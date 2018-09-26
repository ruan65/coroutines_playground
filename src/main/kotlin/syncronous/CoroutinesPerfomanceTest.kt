package syncronous

import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) =

        runBlocking<Unit> {

            val start = System.currentTimeMillis()

            val jobs: List<Job> = List(SIZE) {
                launch {
                    delay(1000L)
                    print("*")
                }
            }
            jobs.forEach { it.join() }

            println()
            println("time nano: ${System.currentTimeMillis() - start}")
        }
