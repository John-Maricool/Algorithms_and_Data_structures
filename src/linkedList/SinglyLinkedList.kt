package linkedList


fun main(){
    val singlyLinkedList = SinglyLinkedList<String>()
    singlyLinkedList.addDataToHead("Jonny")
    singlyLinkedList.addDataToHead("Peter")
    singlyLinkedList.addDataToTail("Festus")
    singlyLinkedList.addDataToHead("Mercy")
    singlyLinkedList.addDataToTail("Goodness")
    singlyLinkedList.addDataToHead("Lovely")
    singlyLinkedList.addDataToTail("Remi")
    singlyLinkedList.addDataToHead("Best")
    println("Size of list")
    println("------------------------------------------")
    println(singlyLinkedList.size)

    println()
    println("Current tail")
    println("------------------------------------------")
    println(singlyLinkedList.tail.toString())

    println()
    println("Current head")
    println("------------------------------------------")
    println(singlyLinkedList.head.toString())

    println()
    println(" Remove Current head")
    println("------------------------------------------")
    println(singlyLinkedList.removeCurrentHead())
    println(singlyLinkedList.removeCurrentHead())

    println()
    println("Current head")
    println("------------------------------------------")
    println(singlyLinkedList.head.toString())

    println()
    println("Search for Element")
    println("------------------------------------------")
    println(singlyLinkedList.search("Per"))

    println()
    println("All list")
    println("------------------------------------------")
    singlyLinkedList.toString()
}

class Node<T>{
    var data: T? = null
    var nextNode: Node<T>? = null

    constructor(data: T, nextNode: Node<T>?){
        this.data = data
        this.nextNode = nextNode
    }

    constructor(){

    }

    override fun toString(): String {
        println("Node data is ${data}")
        return ""
    }
}

class SinglyLinkedList<T>{
    var size = 0
    var head: Node<T>? = Node()
    var tail: Node<T>? = Node()

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun addDataToHead(data: T){
        if (isEmpty()){
            val node = Node(data, null)
            head = node
            tail = node
        }else{
            val node = Node(data, head)
            head = node
        }
        size++
    }

    fun search(data: T): Boolean {
        if (!isEmpty()){
            var trav = head
            while (trav != null){
                val next = trav.nextNode
                if (data == trav.data){
                    return true
                }
                trav = next
            }
            return false
        }else{
            return false
        }
    }

    fun addDataToTail(data: T) {
        if (isEmpty()) {
            val node = Node(data, null)
            head = node
            tail = node
        } else {
            val node = Node(data, null)
            tail?.nextNode = node
            tail = node
        }
        size++
    }

    fun peek(): T?{
        return if (isEmpty()){
            null
        }else{
            head?.data
        }
    }

    fun removeCurrentHead(): T?{
        return if (isEmpty()){
            null
        }else{
            val nextNode = head?.nextNode
            if (nextNode != null)
                head = nextNode
            size--
            nextNode?.data
        }
    }

    fun removeCurrentTail(){
        if (!isEmpty()){
            var trav = head
            while (trav != null){
                val next = trav.nextNode
                if (next == tail){
                    tail = next
                    tail?.nextNode = null
                }
                trav = next
            }
        }
        size--
    }

    fun remove(data: T){
        var trav = head
        while (trav != null){
            val next = trav.nextNode
            if (next?.data == data){
                trav.nextNode = next?.nextNode
                break
            }
            trav = next
        }
        size--
    }

   override fun toString(): String {
        var trav = head
        while (trav != null){
            println(trav.toString())
            trav = trav.nextNode
        }
        return ""
    }
}
