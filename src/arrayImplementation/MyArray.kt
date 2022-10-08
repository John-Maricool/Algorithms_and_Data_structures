package arrayImplementation

import java.lang.IndexOutOfBoundsException
import java.util.*

/**
 * I'm going to be implemnting a dynamic list with a static array.
 */
fun main() {
    val arr = MyArray(2)
    println("Array Indexes")
    println("------------------------------------")
    arr.add("20")
    print(arr.indexOf("20"))
    arr.add("4")
    print(arr.indexOf("4"))
    arr.add("29")
    print(arr.indexOf("29"))
    arr.add("8")
    print(arr.indexOf("8"))
    arr.add("190")
    print(arr.indexOf("190"))
    arr.add("70")
    print(arr.indexOf("70"))
    arr.add("Ebua")
    print(arr.indexOf("Ebua"))
    arr.add("Jonnuy")
    print(arr.indexOf("Jonnuy"))
    arr.add("Licwkdbs")
    print(arr.indexOf("Licwkdbs"))
    println()
    println("Initial Array")
    println("----------------------------------------")

    for (i in 0 until arr.size()){
        println(arr.get(i))
    }
    arr.removeAt(1)
    val res = arr.removeAt(4)
    print("removed$res")
    println()
    println("New Array")
    println("----------------------------------------")
    for (i in 0 until arr.size()){
        println(arr.get(i))
    }

    arr.remove("Licwkdbs")
    println()
    println("updated Array")
    println("----------------------------------------")
    for (i in 0 until arr.size()){
        println(arr.get(i))
    }
/*
    arr.removeAt(3)
    arr.removeAt(6)
    arr.forEach {
        println(it)
    }*/
}

class MyArray : Iterable<String?> {
    var array = Array<String?>(2) { "" }
    var len = 0
    var capacity = 0

    constructor(length: Int) {
        this.capacity = length
        array = Array<String?>(capacity) { "" }
    }

    constructor() {
        array = Array<String?>(10) { "" }
        this.capacity = 10
    }

    fun size(): Int {
        return len
    }

    fun isEmpty(): Boolean {
        return size() == 0
    }

    fun get(index: Int): Any? {
        return array[index]
    }

    fun set(index: Int, value: String) {
        if (index < len || index > 0)
            array[index] = value
    }

    override fun iterator(): Iterator<String?> {
        return this.array.iterator()
    }

    fun clear() {
        for (i in array.indices) {
            array[i] = null
        }
        len = 0
    }

    fun add(t: String) {
        if (len + 1 >= capacity) {
            if (capacity == 0) capacity == 1
            else capacity *= 2
            var newArr = Array<String?>(capacity) { "" }
            for (i in 0 until len) {
                newArr[i] = array[i]!!
            }
            array = newArr
        }
        array[len] = t
        ++len
    }

    fun removeAt(index: Int): String? {
        if (index >= len || index < 0)
            throw IndexOutOfBoundsException()
        val data = array[index]
        val newArr = Array<String?>(len - 1) { "" }
        var i = 0
        var j = 0
        while (i < len) {
            if (i == index) {
                i++
                continue
            } else {
                newArr[j] = array[i]!!
                i++
                j++
            }
        }
        array = newArr
        capacity = --len
        return data
    }

    fun indexOf(value: Any): Int {
        for (i in 0 until array.size) {
            if (array[i]!! == value)
                return i
        }
        return -1
    }

    fun remove(obj: Any): Boolean {
        for (i in 0 until array.size) {
            if (array[i]!!.equals(obj)) {
                removeAt(i)
                return true
            }
        }
        return false
    }
}
