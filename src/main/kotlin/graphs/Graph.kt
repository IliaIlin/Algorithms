package graphs

import java.util.*

interface Graph<T> {
    fun addEdge(source: T, destination: T)
    fun getVerticesConnectedTo(vertex: T): List<T>

    fun bfs(startingVertex: T): Set<T> {
        val visitedVertices = LinkedHashSet<T>()
        val queue = LinkedList<T>()
        queue.push(startingVertex)
        while (queue.isNotEmpty()) {
            val currentVertex = queue.poll()
            visitedVertices.add(currentVertex)
            this.getVerticesConnectedTo(currentVertex).filterNot {
                visitedVertices.contains(it)
            }.forEach {
                visitedVertices.add(it)
                queue.add(it)
            }
        }
        return visitedVertices
    }
}

class DirectedGraph<T> : Graph<T> {

    private val adjacencyList = mutableMapOf<T, LinkedList<T>>()
    override fun addEdge(source: T, destination: T) {
        adjacencyList.putIfAbsent(source, LinkedList())
        adjacencyList.putIfAbsent(destination, LinkedList())
        adjacencyList[source]?.add(destination)
    }

    override fun getVerticesConnectedTo(vertex: T): List<T> = adjacencyList[vertex] ?: emptyList()
}

class UndirectedGraph<T> : Graph<T> {

    private val adjacencyList = mutableMapOf<T, LinkedList<T>>()
    override fun addEdge(source: T, destination: T) {
        adjacencyList.putIfAbsent(source, LinkedList())
        adjacencyList.putIfAbsent(destination, LinkedList())
        adjacencyList[source]?.add(destination)
        adjacencyList[destination]?.add(source)
    }

    override fun getVerticesConnectedTo(vertex: T): List<T> = adjacencyList[vertex] ?: emptyList()
}