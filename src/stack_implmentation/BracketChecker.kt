package stack_implmentation

import java.util.*

fun main() {
    println("Enter any bracket sequence below")
    val swq = readLine()

   val res =  performCheck(swq)
    if (res){
        println("Correct sequence")
    }else{
        println("Incorrect sequence")
    }
}

fun performCheck(swq: String?): Boolean{
    if (swq == null){
        print("Error with the sequence")
        return false
    }
    val stack = MyStack<String>()
    var i = 0
    while (i < swq.length){
        if (!stack.isEmpty()){
            val res = compareBracket(swq[i].toString())
            if (res == stack.peek())
                stack.pop()
            else
                stack.push(swq[i].toString())
        }else{
            stack.push(swq[i].toString())
        }
        i++
    }
    return stack.isEmpty()
}

fun compareBracket(seq: String): String?{
    return when(seq){
        "(" -> ")"
        ")" -> "("
        "{" -> "}"
        "}" -> "{"
        "[" -> "]"
        "]" -> "["
        else -> null
    }
}