package rx

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import java.util.concurrent.Callable

class MyCallable : Callable<Unit> {
    override fun call() {
        print(" World")
    }
}

fun main(args: Array<String>) {

    Flowable.fromCallable { "Hello" }.subscribe { print(it) }
    Completable.fromCallable(MyCallable()).subscribe()
    Observable.fromArray(mutableListOf(" 1", " 2", " 3")).flatMapIterable { it }.subscribe { print(it) }
    Observable.fromIterable(mutableListOf(" 5", " 6", " 7")).subscribe { print(it) }
}