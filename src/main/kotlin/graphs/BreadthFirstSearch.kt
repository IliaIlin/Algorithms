package graphs

import java.util.*
import kotlin.collections.LinkedHashSet

class Graph<T> {
    private val adjacencyList = mutableMapOf<T, LinkedList<T>>()

    fun addUndirectedEdge(source: T, destination: T) {
        adjacencyList.putIfAbsent(source, LinkedList())
        adjacencyList.putIfAbsent(destination, LinkedList())
        adjacencyList[source]?.add(destination)
        adjacencyList[destination]?.add(source)
    }

    fun addDirectedEdge(source: T, destination: T) {
        adjacencyList.putIfAbsent(source, LinkedList())
        adjacencyList.putIfAbsent(destination, LinkedList())
        adjacencyList[source]?.add(destination)
    }

    fun bfs(startingVertex: T): Set<T> {
        val visitedVertices = LinkedHashSet<T>()
        val queue = LinkedList<T>()
        queue.push(startingVertex)
        while (queue.isNotEmpty()) {
            val currentVertex = queue.poll()
            visitedVertices.add(currentVertex)
            println("Visiting $currentVertex")
            adjacencyList[currentVertex]?.filterNot {
                visitedVertices.contains(it)
            }?.forEach {
                visitedVertices.add(it)
                queue.add(it)
            }
        }
        return visitedVertices
    }
}