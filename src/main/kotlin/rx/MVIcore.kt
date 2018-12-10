package rx

import com.badoo.mvicore.binder.Binder
import com.badoo.mvicore.binder.using
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

    val input: Consumer<Int> = Consumer { println(it) }

    val transformer: (String) -> Int = {
        it.length
    }
    val binder = Binder()

    binder.bind(output to input using transformer)

}



