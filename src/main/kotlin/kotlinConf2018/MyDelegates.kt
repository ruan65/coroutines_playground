package kotlinConf2018

import kotlin.properties.Delegates.observable
import kotlin.properties.Delegates.vetoable
import kotlin.properties.ObservableProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class WithDelegates {

    var maxCount: Int by observable(initialValue = 0) { property, oldValue, newValue ->

        println("${property.name} is being changed from $oldValue to $newValue")

    }

    var minCount: Int by MyDelegates.myObservable(1000) { prop, old, new ->

        println("custom delegat prop ${prop.name} was $old and now is $new")



    }

    var someCount: Int by vetoable(initialValue = 500) {
        property, oldValue, newValue ->
        newValue > oldValue
    }

    var changeOnlyIfLess by MyDelegates.myVetoable(1000) { prop, old, new ->
        new < old
    }

}


fun main(args: Array<String>) {
    val withDelegates = WithDelegates()

    withDelegates.maxCount = 100

    withDelegates.maxCount = 200

    withDelegates.minCount = 900

    println(withDelegates.someCount)
    withDelegates.someCount = 400
    println(withDelegates.someCount)

    withDelegates.someCount = 900
    println(withDelegates.someCount)

    withDelegates.changeOnlyIfLess = 1000
    println(withDelegates.changeOnlyIfLess)
    withDelegates.changeOnlyIfLess = 1001
    println(withDelegates.changeOnlyIfLess)
    withDelegates.changeOnlyIfLess = 999
    println(withDelegates.changeOnlyIfLess)


}

object MyDelegates {
    public inline fun <T> myObservable(initialValue: T, crossinline ifChange: (prop: KProperty<*>, old: T, new: T) -> Unit)
    : ReadWriteProperty<Any?, T> = object: ObservableProperty<T>(initialValue) {
        override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) {
            return ifChange(property, oldValue, newValue)
        }
    }

    public inline fun <T> myVetoable(initial: T, crossinline check: (prop: KProperty<*>, old: T, new: T) -> Boolean)
    :ReadWriteProperty<Any?, T> = object: ObservableProperty<T> (initial) {
        override fun beforeChange(property: KProperty<*>, oldValue: T, newValue: T): Boolean {
            return check(property, oldValue, newValue)
        }
    }
}