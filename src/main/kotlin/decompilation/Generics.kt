package decompilation

interface Store<in T> {
    fun put(item: T)
}

interface Source<out T> {
    fun take(): T
}

interface Box<T> : Source<T>, Store<T>