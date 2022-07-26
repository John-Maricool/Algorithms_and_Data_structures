package recursion

fun main(args: Array<String>) {
    //printOn(20)
    //printOnRepetedly3(15)
    //printOnRepetedly2(5)
    val result = printFactorial(5)
    println(result)
}

/**
 * This is a recursive function to print numbers.
 * It takes OrderOf (n) to complete.
 */
fun printOn(value: Int) {
    if (value > 1) {
        println(value)
        printOn(value - 1)
    }
}

/**
 * this is done with a recursive function
 */
fun printOnRepetedly(value: Int) {
    if (value >= 1) {
        for (i in 0 until value) {
            println(value)
        }
        printOnRepetedly(value - 1)
    }
}

fun printOnRepetedly3(value: Int) {
    if (value >= 1) {
        for (i in 0 until value) {
            println(value)
        }
        printOnRepetedly(value - 1)
        printOnRepetedly(value - 1)
    }
}


/**
 * the same is done using nested loops
 */
fun printOnRepetedly2(value: Int) {
    var valueSec = value
    while (valueSec >= 1) {
        for (i in 0 until valueSec) {
            println(valueSec)
        }
        valueSec--
    }
}

/**
 * recursive function to get factorial of a number
 */
fun printFactorial(num: Int): Int {
    return if (num <= 1) {
        1
    } else {
        num * printFactorial(num - 1)
    }
}
