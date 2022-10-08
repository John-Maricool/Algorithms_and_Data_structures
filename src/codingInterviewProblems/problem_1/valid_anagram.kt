package codingInterviewProblems.problem_1

/*
******Problem Statement *******
* Given two stringss1 and s2, check if they're anagrams.
* Two strings are anagrams if they're made of the same characters
* with the same frequencies
*
* input are two strings
* output is a boolean
* */

fun main() {
    val result = checkIfAnagrams("danger", "garden")
    println(result)
    val result2 = checkIfAnagrams("ass", "sas")
    println(result2)
    val result3 = checkIfAnagrams("blobs", "oblbs")
    println(result3)
    val result4 = checkIfAnagrams("dangerm", "gardens")
    println(result4)
    val result5 = checkIfAnagrams("saaa", "")
    println(result5)
    val result6 = checkIfAnagrams("last", "tall")
    print(result6)
}


//first implementation
fun checkIfAnagrams(s1: String, s2: String): Boolean {
    if (s1.length == s2.length) {
        val firHM = HashMap<Char, Int>()
        val secHM = HashMap<Char, Int>()

        s1.forEach { str ->
            if (!firHM.containsKey(str)) {
                firHM[str] = s1.countItem { it == str }
            }
        }
        s2.forEach { str ->
            if (!secHM.containsKey(str)) {
                secHM[str] = s2.countItem { it == str }
            }
        }

        for(key in firHM.keys){
            if(!secHM.containsKey(key) || firHM[key] != secHM[key]){
                return false
            }
        }
        return true
    }
    return false
}

//second implementation
fun checkIfAnagramss(s1: String, s2: String): Boolean {
    val arr = s1.toCharArray()
    val sortedS1 = arr.sorted().joinToString("")

    val arr2 = s2.toCharArray()
    val sorted2 = arr2.sorted().joinToString("")

    return sortedS1 == sorted2;
}

fun String.countItem(item: (it: Char) -> Boolean): Int{
   var count = 0
    this.forEach {
        if (item(it)){
            count++
        }
    }
    return count
}