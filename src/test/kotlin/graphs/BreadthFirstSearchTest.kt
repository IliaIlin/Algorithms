package graphs

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BreadthFirstSearchTest {

    @Test
    fun undirectedGraphTest() {
        val graph = UndirectedGraph<Int>()
        graph.addEdge(5, 4)
        graph.addEdge(5, 3)
        graph.addEdge(5, 8)
        graph.addEdge(4, 3)
        graph.addEdge(3, 6)
        graph.addEdge(3, 0)

        assertThat(graph.bfs(5)).containsExactly(5, 4, 3, 8, 6, 0)
        assertThat(graph.bfs(0)).containsExactly(0, 3, 5, 4, 6, 8)
    }

    @Test
    fun directedGraphTest() {
        val graph = DirectedGraph<Int>()
        graph.addEdge(5, 4)
        graph.addEdge(5, 3)
        graph.addEdge(5, 8)
        graph.addEdge(4, 3)
        graph.addEdge(3, 6)
        graph.addEdge(0, 3)

        assertThat(graph.bfs(5)).containsExactly(5, 4, 3, 8, 6)
        assertThat(graph.bfs(0)).containsExactly(0, 3, 6)
    }

    @Test
    fun binaryTreeTest() {
        val tree = BinaryTreeNode(5).apply {
            left = BinaryTreeNode(4)
            right = BinaryTreeNode(8).apply {
                left = BinaryTreeNode(6)
                right = BinaryTreeNode(9)
            }
        }

        assertThat(tree.bfs()).containsExactly(5, 4, 8, 6, 9)
    }
}