package sorting

fun main(args: Array<String>) {
    /*   val listOne = listOf(1, 7, 11, 22, 25)
       val listTwo = listOf(5, 12, 14, 23)
       val listThree = listOf(2, 3, 80, 123, 221, 1223)
       val listFour = listOf(2, 12, 43, 45, 56, 67, 78, 89, 90)*/
    val listFive = listOf(5, 1, 4, 19, 8, 4, 7, 3, 29)
    val result = quicksort(listFive)
    result.forEach {
        println(it)
    }
    /*val res = mergeTwoSortedLists(listOne, listTwo)
    val res2 = mergeTwoSortedLists(listThree, listFour)
    println(res)
    println(res2)
    val merged = mergeTwoSortedLists(res, res2)
    println("The fully merged list is: $merged")*/
}

/**
 * Algorithm for merging two sorted lists while keeping them sorted.
 */
fun mergeTwoSortedLists(listOne: List<Int>, listTwo: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    var i = 0
    var j = 0
    var counter = 1
    while (counter <= listOne.size + listTwo.size) {
        if (i == listOne.size && j < listTwo.size) {
            result.add(listTwo[j])
            j++
        } else if (i < listOne.size && j == listTwo.size) {
            result.add(listOne[i])
            i++
        } else {
            if (listOne[i] <= listTwo[j]) {
                result.add(listOne[i])
                i++
            } else {
                result.add(listTwo[j])
                j++
            }
        }
        counter++
    }
    return result
}
/**
 * merge sort algorithm using recursion
 */

fun mergeSortUsingRecursion(list: List<Int>): List<Int> {
    if (list.size <= 1) {
        return list
    }
    val middle = list.size / 2
    val left = list.subList(0, middle);
    val right = list.subList(middle, list.size);
    return mergeTwoSortedLists(mergeSortUsingRecursion(left), mergeSortUsingRecursion(right))
}

fun partitioning(list: IntArray): Int {
    val pivot = list.first()
    var i = 0
    var j = list.size - 1
    //read code line by line and understand.
    /**
     * Trying to grasp it all once doesn't work
     */
    while (i < j) {
        do {
            i++
        } while (list[i] <= pivot)
        do {
            j--
        } while (list[j] > pivot)
        if (i < j) {
            swap(list, i, j)
        }
    }
    swap(list, j, 0)
    return j
}

fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

/*
fun quicksort(list: IntArray): IntArray {
    val j = partitioning(list = list)
    return quicksort(list.sliceArray(0..j)) + quicksort(list.sliceArray(j + 1..list.size))
}*/
fun quicksort(items: List<Int>): List<Int> {
    if (items.count() < 2) {
        return items
    }
    val pivot = items[items.count() / 2]
    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }
    return quicksort(less) + equal + quicksort(greater)
}


