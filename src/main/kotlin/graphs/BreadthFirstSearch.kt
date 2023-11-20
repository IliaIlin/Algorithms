package graphs

import java.util.*

class Graph<T> {
    private val adjacencyList = mutableMapOf<T, LinkedList<T>>()

    fun addEdge(source: T, destination: T) {
        adjacencyList.putIfAbsent(source, LinkedList())
        adjacencyList.putIfAbsent(destination, LinkedList())
        adjacencyList[source]?.add(destination)
    }

    fun bfs(startingVertex: T) {
        val visitedVertices = mutableSetOf<T>()
        val queue = LinkedList<T>()
        queue.push(startingVertex)
        while (queue.isNotEmpty()) {
            val currentVertex = queue.poll()
            println("Visiting $currentVertex")
            adjacencyList[currentVertex]?.filterNot {
                visitedVertices.contains(it)
            }?.forEach {
                visitedVertices.add(it)
                queue.add(it)
            }
        }
    }
}

fun main() {
    val graph = Graph<Int>()
    graph.addEdge(1, 5)
    graph.addEdge(1, 2)
    graph.addEdge(1, 0)

    graph.addEdge(5, 2)

    graph.addEdge(5, 6)
    graph.addEdge(2, 6)
    graph.addEdge(0, 6)
    graph.addEdge(0, 10)

    graph.bfs(1)
}