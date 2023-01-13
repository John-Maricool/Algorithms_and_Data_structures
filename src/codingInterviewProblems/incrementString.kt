package codingInterviewProblems

/*

Your job is to write a function which increments a string, to create a new string.

If the string already ends with a number, the number should be incremented by 1.
If the string does not end with a number. the number 1 should be appended to the new string.
Examples:

foo -> foo1
 */


fun main() {
    println(incrementString("foobar000"))
    println(incrementString("foobar999"))
    println(incrementString("foobar00999"))
    println(incrementString("foo"))
    println(incrementString("foobar001"))
    println(incrementString("foobar1"))
    print(incrementString("1"))
    println(incrementString(""))
    println(incrementString("009"))
}

//my implementation is not totally correct
fun incrementString(str: String): String {
    if (str.isEmpty){
        return "1"
    }
    else if ((!str[str.lastIndex].isDigit()) && !str.contains("[0-9]".toRegex())) {
        return str + "1";
    } else {
        var newStr = str
        var integer: Int
        val integerStr: Int
        var strr: String
        var beg: String = ""
        if (str[0].isDigit()) {
            for (i in str.indices) {
                if (str[i].isLetter()) {
                    newStr = str.substring(i)
                    beg = str.substring(0, i)
                    break
                }

            }
        }
        strr = newStr.filter {
            !it.isDigit()
        }
        integer = newStr.filter {
            it.isDigit()
        }.toInt()

        integerStr = newStr.filter { it.isDigit() }.length

        integer += 1
        strr = beg + strr + integer.toString().padStart(integerStr, '0')
        return strr;
    }
}

