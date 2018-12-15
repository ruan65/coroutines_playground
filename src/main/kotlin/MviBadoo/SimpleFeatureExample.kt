package MviBadoo

import com.badoo.mvicore.feature.ReducerFeature
import MviBadoo.Feature1.*
import MviBadoo.Feature1.Wish.*
import com.badoo.mvicore.element.Reducer

class Feature1 : ReducerFeature<Wish, State, Nothing>(
        initialState = State(),
        reducer = ReducerImpl()
) {

    data class State(
            val counter: Int = 0
    )

    sealed class Wish {
        object IncrementCounter : Wish()
    }

    class ReducerImpl : Reducer<State, Wish> {
        override fun invoke(state: State, wish: Wish): State = when(wish) {
            IncrementCounter -> state.copy(counter = state.counter + 1)
        }
    }
}