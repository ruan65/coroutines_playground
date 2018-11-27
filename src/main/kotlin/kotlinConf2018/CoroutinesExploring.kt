package kotlinConf2018

import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.buildSequence


fun process(n: Int) : Int {
    println("process: ${Thread.currentThread()}")
    return n
}

val sequence = buildSequence {

    println("one")
    yield(1)

    println("two")
    yield(2)

    println("three")
    yield(3)

    println("done")
}

fun main(args: Array<String>) = runBlocking<Unit>{
//    println(Thread.currentThread())
//
//    GlobalScope.launch {
//        process(2000)
//    }
//
//    Thread.sleep(2000)

    for (value in sequence) {
        println("The value is: $value")
    }
}