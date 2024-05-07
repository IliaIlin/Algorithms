package graphs

import java.util.*

interface Graph<T> {
    fun addEdge(source: T, destination: T)
    fun getVerticesConnectedTo(vertex: T): List<T>

    fun bfs(startingVertex: T): Set<T> {
        val visitedVertices = LinkedHashSet<T>()
        val queue = LinkedList<T>()
        queue.push(startingVertex)
        visitedVertices.add(startingVertex)

        while (queue.isNotEmpty()) {
            val currentVertex = queue.poll()
            for (neighbour in getVerticesConnectedTo(currentVertex)) {
                if (visitedVertices.contains(neighbour)) {
                    continue
                }
                queue.add(neighbour)
                visitedVertices.add(neighbour)
            }
        }
        return visitedVertices
    }

    fun iterativeDfs(startingVertex: T): Set<T> {
        val visitedVertices = LinkedHashSet<T>()
        val stack = Stack<T>()
        stack.push(startingVertex)
        while (stack.isNotEmpty()) {
            val currentVertex = stack.pop()
            visitedVertices.add(currentVertex)
            for (neighbour in getVerticesConnectedTo(currentVertex).reversed()) {
                if (visitedVertices.contains(neighbour)) {
                    continue
                }
                stack.push(neighbour)
            }
        }
        return visitedVertices
    }

    fun recursiveDfs(startingVertex: T): Set<T> {
        val visitedVertices = mutableSetOf<T>()
        recursiveDfs(startingVertex, visitedVertices)
        return visitedVertices
    }

    private fun recursiveDfs(currentVertex: T, visitedVertices: MutableSet<T>) {
        visitedVertices.add(currentVertex)
        for(neighbour in getVerticesConnectedTo(currentVertex)) {
            if(visitedVertices.contains(neighbour)){
                continue
            }
            recursiveDfs(neighbour, visitedVertices)
        }
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