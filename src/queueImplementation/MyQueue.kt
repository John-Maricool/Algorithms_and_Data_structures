package queueImplementation

import linkedList.SinglyLinkedList

fun main(){
    println("----------Queue Implementation-------------")
    val myQueue = MyQueue<String>()
    myQueue.enqueue("Ikenwa")
    myQueue.enqueue("John")
    myQueue.enqueue("Ebuka")
    myQueue.enqueue("Oracle")
    myQueue.enqueue("Mario")

    myQueue.enqueue("Cool")

    println(myQueue.dequeue())
    println(myQueue.dequeue())
    println(myQueue.size())
    println(myQueue.dequeue())
    println(myQueue.size)

}

class MyQueue<T>{
    private val list = SinglyLinkedList<T?>()
    var size = 0

    fun enqueue(value: T?){
        list.addDataToTail(value)
        size++
    }

    fun dequeue(): T?{
        val lastElement = list.head
        list.removeCurrentHead()
        size--
        return lastElement?.data
    }

    fun peek(): T? {
        return list.head?.data
    }

    fun contains(value: T): Boolean {
        return list.search(value)
    }

    fun isEmpty(): Boolean {
        return list.size == 0
    }

    fun size(): Int{
        return size
    }
}







