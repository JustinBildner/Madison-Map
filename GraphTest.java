import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class GraphTest {

    private MadisonMap<String> graph;

    /**
     * Instantiate graph from last week's shortest path activity.
     */
    @BeforeEach
    public void createGraph() {
        graph = new MadisonMap<>();
        // insert vertices A-F
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");
        // insert edges from Week 11. Shortest Path Activity
        graph.insertEdge("A","B",6);
        graph.insertEdge("A","C",2);
        graph.insertEdge("A","D",5);
        graph.insertEdge("B","E",1);
        graph.insertEdge("B","C",2);
        graph.insertEdge("C","B",3);
        graph.insertEdge("C","F",1);
        graph.insertEdge("D","E",3);
        graph.insertEdge("E","A",4);
        graph.insertEdge("F","A",1);
        graph.insertEdge("F","D",1);

        graph.insertEdge("B","A",6);
        graph.insertEdge("C","A",2);
        graph.insertEdge("D","A",5);
        graph.insertEdge("E","B",1);
        graph.insertEdge("C","B",2);
        graph.insertEdge("B","C",3);
        graph.insertEdge("F","C",1);
        graph.insertEdge("E","D",3);
        graph.insertEdge("A","E",4);
        graph.insertEdge("A","F",1);
        graph.insertEdge("D","F",1);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to F.
     */
    @Test
    public void MinTreeA() {
        assertTrue(graph.getPathCost("A", "F") == 3);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to F.
     */
    @Test
    public void testPathCostAtoF() {
        assertTrue(graph.getPathCost("A", "F") == 3);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to D.
     */
    @Test
    public void testPathCostAtoD() {
        assertTrue(graph.getPathCost("A", "D") == 4);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex
     * A to D.
     */
    @Test
    public void testPathAtoD() {
        assertTrue(graph.shortestPath("A", "D").toString().equals(
            "[A, C, F, D]"
        ));
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex
     * A to F.
     */
    @Test
    public void testPathAtoF() {
        assertTrue(graph.shortestPath("A", "F").toString().equals(
            "[A, C, F]"
        ));
    }


    /**
     * Checks the distance/total weight cost from the vertex A to E.
     */
    @Test
    public void testPathCostAtoE() {
        assertTrue(graph.getPathCost("A", "E") == 6);
    }

    /**
     * Checks the ordered sequence of data within vertices from the vertex
     * A to E.
     */
    @Test
    public void testPathAtoE() {
        assertTrue(graph.shortestPath("A", "E").toString().equals(
            "[A, C, B, E]"
        ));
    }

    /**
     * Checks the distance/total weight cost from the vertex B to F.
     */
    @Test
    public void testPathCostBtoF() {
        assertTrue(graph.getPathCost("B", "F") == 3);
    }

    /**
     * Checks the Predessor to B along the shortest path from F to B.
     */
    @Test
    public void testPredecessorFtoB() {
        assertTrue(graph.dijkstrasShortestPath("F", "B").dataSequence.get(graph.dijkstrasShortestPath("F", "B").dataSequence.size()-2).equals("C"));
    }

    /**
     * Checks the distance/total weight cost from the vertex E to B.
     */
    @Test
    public void testPathCostEtoB() {
        assertTrue(graph.getPathCost("E", "B") == 9);
    }


    /**
     * Checks that method throws an exception when there is no path from start to end
     */
    @Test
    public void testNullPointException() {
        graph.removeEdge("C", "F");
        assertThrows(NoSuchElementException.class, () -> { graph.shortestPath("A", "F");});
    }



}
