package graphs

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BreadthFirstSearchTest {

    @Test
    fun undirectedGraphTest() {
        val graph = UndirectedGraph<Int>()
        graph.addEdge(0, 1)
        graph.addEdge(0, 5)
        graph.addEdge(5, 4)
        graph.addEdge(1, 2)
        graph.addEdge(1, 4)
        graph.addEdge(2, 3)
        graph.addEdge(4, 3)

        assertThat(graph.bfs(0)).containsExactly(0, 1, 5, 2, 4, 3)
        assertThat(graph.bfs(2)).containsExactly(2, 1, 3, 0, 4, 5)
    }

    @Test
    fun directedGraphTest() {
        val graph = DirectedGraph<Int>()
        graph.addEdge(0, 1)
        graph.addEdge(0, 5)
        graph.addEdge(1, 4)
        graph.addEdge(5, 4)
        graph.addEdge(2, 1)
        graph.addEdge(2, 3)
        graph.addEdge(3, 4)

        assertThat(graph.bfs(0)).containsExactly(0, 1, 5, 4)
        assertThat(graph.bfs(2)).containsExactly(2, 1, 3, 4)
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