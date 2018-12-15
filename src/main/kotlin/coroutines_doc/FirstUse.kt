package coroutines_doc

import kotlinx.coroutines.experimental.*

//fun main(args: Array<String>) = runBlocking<Unit> {
//
//    //    println("$this")
//    val job = GlobalScope.launch {
//        //        println("$this")
//        delay(3000)
//        print("World!")
//    }
//
//    print("Hello, ")
////    job.join()
//}

//fun main(args: Array<String>) = runBlocking<Unit> {
//
//    this.launch {
//        delay(3000)
//        print("World!")
//    }
//
//    print("Hello, ")
//}

fun main(args: Array<String>) = runBlocking {

    launch { doWorld() }

    print("Hello, ")
}

suspend fun doWorld() {

    delay(2000)
    print("World!")

}