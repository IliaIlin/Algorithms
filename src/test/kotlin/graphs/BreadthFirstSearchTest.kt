package graphs

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BreadthFirstSearchTest {

    @Test
    fun undirectedGraphTest() {
        val graph = Graph<Int>()
        graph.addUndirectedEdge(1, 5)
        graph.addUndirectedEdge(1, 2)
        graph.addUndirectedEdge(1, 0)

        graph.addUndirectedEdge(5, 2)

        graph.addUndirectedEdge(5, 6)
        graph.addUndirectedEdge(2, 6)
        graph.addUndirectedEdge(0, 6)
        graph.addUndirectedEdge(0, 10)

        assertThat(graph.bfs(1)).containsExactly(1, 5, 2, 0, 6, 10)
        assertThat(graph.bfs(2)).containsExactly(2, 1, 5, 6, 0, 10)
    }

    @Test
    fun directedGraphTest() {
        val graph = Graph<Int>()
        graph.addDirectedEdge(1, 5)
        graph.addDirectedEdge(1, 2)
        graph.addDirectedEdge(1, 0)

        graph.addDirectedEdge(5, 2)

        graph.addDirectedEdge(5, 6)
        graph.addDirectedEdge(2, 6)
        graph.addDirectedEdge(0, 6)
        graph.addDirectedEdge(0, 10)

        assertThat(graph.bfs(1)).containsExactly(1, 5, 2, 0, 6, 10)
        assertThat(graph.bfs(2)).containsExactly(2, 6)
    }
}