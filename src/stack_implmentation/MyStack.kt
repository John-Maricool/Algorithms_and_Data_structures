package stack_implmentation

import linkedList.SinglyLinkedList
import java.util.*

fun main(){
    println("------------Normal stack---------------")

    val newStack = Stack<String>()
    newStack.push("Ebuka")
    newStack.push("Ikenwa")
    newStack.push("John")
    newStack.push("Peter")
    newStack.push("Obi")
    newStack.push("Love")
    newStack.push("Jinn")
    newStack.push("Maricool")

    println(newStack.search("Ikenwa"))
    println(newStack.search("Peter"))
    println(newStack.peek())
    println(newStack.pop())
    println(newStack.pop())
    println(newStack.peek())

    println("------------Custom stack---------------")

    val myNewStack = MyStack<String>()
    myNewStack.push("Ebuka")
    myNewStack.push("Ikenwa")
    myNewStack.push("John")
    myNewStack.push("Peter")
    myNewStack.push("Obi")
    myNewStack.push("Love")
    myNewStack.push("Jinn")
    myNewStack.push("Maricool")

    println(myNewStack.search("Inwa"))
    println(myNewStack.search("Pter"))
    println(myNewStack.peek())
    println(myNewStack.pop())
    println(myNewStack.pop())
    println(myNewStack.peek())
}

/**
 * Implementing a stack using my custom singly linked list
 *
 */
class MyStack<T>{
    val list = SinglyLinkedList<T?>()
    var size = 0
    fun push(value: T?){
        list.addDataToHead(value)
        size++
    }

    fun pop(): T?{
        val lastElement = list.head
        list.removeCurrentHead()
        size--
        return lastElement?.data
    }

    fun peek(): T? {
        return list.head?.data
    }

    fun search(value: T): Boolean {
        return list.search(value)
    }

    fun isEmpty(): Boolean {
        return list.size == 0
    }

    fun size(): Int{
        return size
    }
}