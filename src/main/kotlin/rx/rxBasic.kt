package rx

import io.reactivex.Observable

fun main(args: Array<String>) {
    val just = Observable.just("Hello")

    just.subscribe { print(it) }
}