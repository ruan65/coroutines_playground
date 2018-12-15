package rx

import com.badoo.mvicore.element.Reducer
import com.badoo.mvicore.feature.ReducerFeature
import rx.SimpleFeature.*
import rx.SimpleFeature.Wish.*

class SimpleFeature : ReducerFeature<Wish, State, Nothing>(
        initialState = State(),
        reducer = ReducerImpl()
) {


    data class State(
            val counter: Int = 0,
            val someText: String = ""
    )

    sealed class Wish {
        object IncreaseCounter : Wish()
        data class SetText(val text: String) : Wish()
    }

    class ReducerImpl : Reducer<State, Wish> {
        override fun invoke(state: State, wish: Wish): State {

            return when (wish) {
                is IncreaseCounter -> state.copy(counter = state.counter + 1)
                is SetText -> state.copy(someText = wish.text)
            }
        }
    }
}

fun main(args: Array<String>) {

    val state = State()


}