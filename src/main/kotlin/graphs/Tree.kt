package graphs

import java.util.*
import kotlin.collections.LinkedHashSet

class BinaryTreeNode<T>(val value: T) {
    var left: BinaryTreeNode<T>? = null
    var right: BinaryTreeNode<T>? = null

    fun bfs(): Set<T> {
        val visitedNodes = LinkedHashSet<T>()
        val queue = LinkedList<BinaryTreeNode<T>>()
        queue.push(this)
        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()
            visitedNodes.add(currentNode.value)
            currentNode.left?.let { queue.add(it) }
            currentNode.right?.let { queue.add(it) }
        }
        return visitedNodes
    }
}