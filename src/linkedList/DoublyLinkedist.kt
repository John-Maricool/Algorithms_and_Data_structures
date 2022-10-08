package linkedList

fun main() {
    val doubleLinkedList = DoublyLinkedList<String>()
    doubleLinkedList.addDataToHead("Jonny")
    doubleLinkedList.addDataToHead("Peter")
    doubleLinkedList.addDataToTail("Festus")
    doubleLinkedList.addDataToHead("Mercy")
    doubleLinkedList.addDataToTail("Goodness")
    doubleLinkedList.addDataToHead("Lovely")
    doubleLinkedList.addDataToTail("Remi")
    doubleLinkedList.addDataToHead("Best")
    println("Size of list")
    println("------------------------------------------")
    println(doubleLinkedList.size)

    println()
    println("Current tail")
    println("------------------------------------------")
    println(doubleLinkedList.tail.toString())

    println()
    println("Current head")
    println("------------------------------------------")
    println(doubleLinkedList.head.toString())

    println()
    println("All list")
    println("------------------------------------------")
    doubleLinkedList.toString()

    println()
    println("All list Rev")
    println("------------------------------------------")
    doubleLinkedList.toStringRev()
}

class DNode<T> {
    var data: T? = null
    var nextNode: DNode<T>? = null
    var prevNode: DNode<T>? = null


    constructor(data: T, nextNode: DNode<T>?, prevNode: DNode<T>?) {
        this.data = data
        this.nextNode = nextNode
        this.prevNode = prevNode
    }

    constructor() {

    }

    override fun toString(): String {
        println("Node data is ${data}")
        return ""
    }
}

class DoublyLinkedList<T> {
    var size = 0
    var head: DNode<T>? = DNode()
    var tail: DNode<T>? = DNode()

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun addDataToHead(data: T) {
        if (isEmpty()) {
            val node = DNode(data, null, null)
            head = node
            tail = node
        } else {
            val node = DNode(data, head, null)
            head?.prevNode = node
            head = node
        }
        size++
    }

    fun addDataToTail(data: T) {
        val node = DNode(data, null, tail)
        tail?.nextNode = node
        tail = node
        size++
    }

    fun peek(): T? {
        return if (isEmpty()) {
            null
        } else {
            head?.data
        }
    }

    fun removeCurrentHead(): T? {
        return if (isEmpty()) {
            null
        } else {
            val nextNode = head?.nextNode
            if (nextNode != null) {
                head = nextNode
                nextNode.prevNode = null
                size--
            }
            head?.data
        }
    }

    fun removeCurrentTail() {
        if (!isEmpty()) {
            tail = tail?.prevNode
            tail?.nextNode = null
        }
        size--
    }

    fun remove(data: T) {
        var trav = head
        while (trav != null) {
            if (trav.data == data) {
                trav.prevNode = trav.nextNode
                break
            }
            trav = trav.nextNode
        }
        size--
    }

    override fun toString(): String {
        var trav = head
        while (trav != null) {
            println(trav.toString())
            trav = trav.nextNode
        }
        return ""
    }

    fun toStringRev(): String {
        var trav = tail
        while (trav?.prevNode != null) {
            println(trav.toString())
            trav = trav.prevNode
        }
        return ""
    }
}









