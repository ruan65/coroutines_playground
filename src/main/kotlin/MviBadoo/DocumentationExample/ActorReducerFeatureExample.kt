package MviBadoo.DocumentationExample

import com.badoo.mvicore.element.Actor
import com.badoo.mvicore.element.*
import com.badoo.mvicore.feature.ActorReducerFeature
import io.reactivex.Observable
import MviBadoo.DocumentationExample.Feature2.*
import MviBadoo.DocumentationExample.Feature2.Wish.*
import MviBadoo.DocumentationExample.Feature2.Effect.*
import io.reactivex.schedulers.Schedulers

class Feature2 : ActorReducerFeature<Wish, Effect, State, Nothing>(
        initialState = State(),
        actor = ActorImpl(),
        reducer = ReducerImpl()
) {

    data class State(
            val isLoading: Boolean = false,
            val payload: String? = null
    )

    sealed class Wish {
        object LoadNewData : Wish()
    }

    sealed class Effect {
        object StartedLoading : Effect()
        data class FinishedWithSuccess(val payload: String) : Effect()
        data class FinishedWithError(val throwable: Throwable) : Effect()
    }

    class ActorImpl : Actor<State, Wish, Effect> {

        private val service: Observable<String> = Observable.just("Hello feature!!!!!!!!!!!!!!!!!!!!!!!!")

        override fun invoke(state: State, wish: Wish): Observable<out Effect> = when (wish) {
            is LoadNewData -> {
                service
                        .observeOn(Schedulers.newThread())
                        .map { FinishedWithSuccess(payload = it) as Effect }
                        .startWith(StartedLoading)
                        .onErrorReturn { FinishedWithError(it) }
            }
            else -> Observable.empty()
        }
    }

    class ReducerImpl : Reducer<State, Effect> {
        override fun invoke(state: State, effect: Effect): State = when(effect) {
            is StartedLoading -> state.copy(isLoading = true)
            is FinishedWithSuccess -> state.copy(isLoading = false, payload = effect.payload)
            is FinishedWithError -> state.copy(isLoading = false)
        }
    }
}

fun main(args: Array<String>) {

    val feature2 = Feature2()

    val news = feature2.news


    println("news: ${news}")
}