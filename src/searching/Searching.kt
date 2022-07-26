package searching

fun main(args: Array<String>) {
    val list = listOf(1, 2, 4, 5, 6, 9, 10, 12, 13, 15, 27, 27, 27, 30, 41, 44, 46, 47)
    //val res = binarySearch(list, 3)
    //print(res)
    /*val res = binarySearchValue(list, 47)
    print(res)*/
    val res = binarySearchUsingRecursion(list, 0, 18, 47)
    print(res)

}

/**
 * This binary search implementation just checks if the value is in the list
 * It returns a boolean
 */
fun binarySearch(list: List<Int>, value: Int): Boolean {
    if (list.isEmpty()) {
        return false
    } else if (value == list.first() || value == list.last()) {
        return true
    } else {
        val mid = list.size / 2
        return when {
            value == list[mid] -> {
                true
            }
            value > list[mid] -> {
                val newlist = list.subList(mid + 1, list.size - 1)
                binarySearch(newlist, value)
            }
            else -> {
                val newlist = list.subList(0, mid - 1)
                binarySearch(newlist, value)
            }
        }
    }
}

/**
 * This binary search implementation gets the index of the value i present
 * in the list else
 * It returns null
 */
fun binarySearchValue(list: List<Int>, value: Int): Int? {
    var first = 0
    var last = list.size
    var resultIndex: Int? = null
    if (list.isNotEmpty()) {
        while (first <= last) {
            val mid = (last + first) / 2
            if (list[mid] == value) {
                resultIndex = mid
                break
            } else {
                if (list[mid] > value) {
                    last = mid - 1
                } else {
                    first = mid + 1
                }
            }
        }
        return resultIndex
    } else {
        return null
    }
}

/**
 * This binary search implementation gets the index of the value i present
 * in the list else
 * It returns null
 * It also uses recursive functions for its implementation
 */
fun binarySearchUsingRecursion(list: List<Int>, low: Int, high: Int, key: Int): Int? {
    if (low == high) {
        return if (list[low] == key) {
            low
        } else {
            null
        }
    } else {
        val mid = (low + high) / 2
        return if (list[mid] == key) {
            mid
        } else {
            if (list[mid] > key) {
                binarySearchUsingRecursion(list, low, mid - 1, key)
            } else {
                binarySearchUsingRecursion(list, mid + 1, high, key)
            }
        }
    }
}