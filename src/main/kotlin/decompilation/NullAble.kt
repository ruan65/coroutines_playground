package decompilation

class A(var b: String)


var a: A? = null

fun main(args: Array<String>) {
    val b = a?.b
}