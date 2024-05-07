package graphs

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DepthFirstSearchTest {
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

        assertThat(graph.iterativeDfs(0)).containsExactly(0, 1, 2, 3, 4, 5)
        assertThat(graph.recursiveDfs(0)).containsExactly(0, 1, 2, 3, 4, 5)
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

        assertThat(graph.iterativeDfs(0)).containsExactly(0, 1, 4, 5)
        assertThat(graph.recursiveDfs(0)).containsExactly(0, 1, 4, 5)

        assertThat(graph.iterativeDfs(2)).containsExactly(2, 1, 4, 3)
        assertThat(graph.recursiveDfs(2)).containsExactly(2, 1, 4, 3)
    }
}