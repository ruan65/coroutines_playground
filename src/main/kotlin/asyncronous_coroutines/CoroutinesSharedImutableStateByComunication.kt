package asyncronous_coroutines

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.SendChannel
import kotlinx.coroutines.experimental.selects.select

class Location (val link: String)
class Ref(val link: String) {
    fun resolveLocation() = Location(link)
}

val references = listOf<Ref>()

val locations = listOf<Location>()



fun processContent(ref: String, content: String) {


}

fun CoroutineScope.downloader(
        refs: ReceiveChannel<Ref>,
        locations: SendChannel<Location>,
        contents: ReceiveChannel<LcContent>
) = launch {

    val requested = mutableMapOf<Location, MutableList<Ref>>()

    while (true) {
        select<Unit> {
            refs.onReceive {ref ->
                val resolveLocation = ref.resolveLocation()
                val refs = requested[resolveLocation]
                if (refs == null) {
                    requested[resolveLocation] = mutableListOf(ref)
                    locations.send(resolveLocation)
                } else {
                    refs.add(ref)
                }
            }
            contents.onReceive {}
        }
    }
//    for (ref in references) {
//        val location = ref.resolveLocation()
//
//        if (requested.add(location)) {
//            // schedule download
//        }
//        processContent(ref.link, "Hello")
//    }
}

fun CoroutineScope.worker(
        locations: ReceiveChannel<Location>,
        contents: SendChannel<LcContent>
) = launch {
    for (lc in locations) {
        val content = downloadContent(lc)
        processContent(lc.link, "content")
    }
}

data class Content(val content: String)

data class LcContent(val lc: Location, val content: Content) {

}

fun downloadContent(lc: Location): String {
    return "This is content......"
}


fun mainlyTwo(args: Array<String>) = runBlocking{
    val job =
            launch {
                val requested = mutableSetOf<Location>()

                for (ref in references) {
                    val location = ref.resolveLocation()

                    if (requested.add(location)) {
                        // schedule download
                    }
                    processContent(ref.link, "Hello")
                }
            }

    job.invokeOnCompletion {
        runBlocking {
            println("Finished")
        }
    }

    job.join()
}

fun main(args: Array<String>) {
    mainlyTwo(args)
}
