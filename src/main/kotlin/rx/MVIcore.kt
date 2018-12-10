package rx

import com.badoo.mvicore.binder.Binder
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.functions.Consumer
import io.reactivex.subjects.Subject

fun main(args: Array<String>) {

    val output: ObservableSource<String> = Observable.just(
            "first",
            "second",
            "third"
    )

    val input: Consumer<String> = Consumer { println(it) }

    val binder = Binder()

    binder.bind(output to input)

}



