package codingInterviewProblems

import java.lang.StringBuilder


/* Given a string s, repeat this operation zero or more times
to create the lexicographically smallest string possible

1. Select two characters that exist in the string c1 and c2.
2. Replace all occurrences of c1 with c2 and all occurrences of c2 with c1

Note: For two strings x and y of length n. x is lexicographically smaller than y if the first
non matching character in x is less than the character at that position in y
 */


fun knowTheSmallerLexiString(s1: String, s2: String): String {
    //Am assuming that s1 and s2 have the same length
    for (i in s1.indices) {
        if (s1[i] != s2[i]) {
            return if (s1[i] > s2[i])
                s2
            else
                s1
        }
    }
    return s1
}

fun replaceOccurrenceOfChar(s: String, ch1: Char, ch2: Char): String {
    val sToList = s.toMutableList()
    for (i in sToList.indices) {
        if (sToList[i] == ch1) {
            sToList[i] = ch2
        } else if (sToList[i] == ch2) {
            sToList[i] = ch1
        }
    }
    return sToList.toString()
}

