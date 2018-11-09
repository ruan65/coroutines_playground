package destructuring

data class TwoVals(val fist: String, val second: String, var third: String)


fun main(args: Array<String>) {
    val twoVals = TwoVals("Hi", "There", "My")
    val (one, _, two) = twoVals

    println(twoVals)

    println(one)
    println("${two}")
}