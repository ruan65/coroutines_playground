package MviBadoo.DocumentationExample

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

fun main(args: Array<String>) {


    val source: ObservableSource<String> = Observable.just("HIHIHI")

//    val input: Consumer<String> = Consumer { s -> print(s) }
    val input: Observer<String> = TheObserver()

    source.subscribe(input)
}

class TheObserver<String> : Observer<String> {

    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: String) {
        print(t)
    }

    override fun onError(e: Throwable) {
    }
}