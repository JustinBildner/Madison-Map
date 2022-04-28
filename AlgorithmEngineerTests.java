import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the implementation of CS400Graph for the individual component of
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 */
public class AlgorithmEngineerTests {

    private MadisonMap<String> graph;

    /**
     * Instantiate graph from last week's shortest path activity.
     */
    @BeforeEach
    public void createGraph() {
        graph = new MadisonMap<>();
        // insert vertices A-F
        graph.insertVertex("1");
        graph.insertVertex("2");
        graph.insertVertex("3");
        graph.insertVertex("4");
        graph.insertVertex("5");
        graph.insertVertex("6");
        graph.insertVertex("7");
        // insert edges from Week 11. Shortest Path Activity

        graph.insertEdge("1","6",10);
        graph.insertEdge("1","2",28);
        graph.insertEdge("2","3",16);
        graph.insertEdge("2","7",14);
        graph.insertEdge("6","5",25);
        graph.insertEdge("5","7",24);
        graph.insertEdge("7","4",18);
        graph.insertEdge("5","4",22);
        graph.insertEdge("4","3",12);

        graph.insertEdge("6","1",10);
        graph.insertEdge("2","1",28);
        graph.insertEdge("3","2",16);
        graph.insertEdge("7","2",14);
        graph.insertEdge("5","6",25);
        graph.insertEdge("7","5",24);
        graph.insertEdge("4","7",18);
        graph.insertEdge("4","5",22);
        graph.insertEdge("3","4",12);
    }

    /**
     * Checks the distance/total weight cost from the vertex A to F.
     */
    @Test
    public void MinTreeA() {
        System.out.println(graph.minTreeVert("1").toString());



//        System.out.println(graph.minTreeEdge("A").toString());




//        assertTrue(graph.minTree("A").toString().equals(
//            "[A, F, E, D, C, B, G]"
//        ));
    }
//
//    /**
//     * Checks the distance/total weight cost from the vertex A to F.
//     */
//    @Test
//    public void testPathCostAtoF() {
//        assertTrue(graph.getPathCost("A", "F") == 3);
//    }
//
//    /**
//     * Checks the distance/total weight cost from the vertex A to D.
//     */
//    @Test
//    public void testPathCostAtoD() {
//        assertTrue(graph.getPathCost("A", "D") == 4);
//    }
//
//    /**
//     * Checks the ordered sequence of data within vertices from the vertex
//     * A to D.
//     */
//    @Test
//    public void testPathAtoD() {
//        assertTrue(graph.shortestPath("A", "D").toString().equals(
//            "[A, C, F, D]"
//        ));
//    }
//
//    /**
//     * Checks the ordered sequence of data within vertices from the vertex
//     * A to F.
//     */
//    @Test
//    public void testPathAtoF() {
//        assertTrue(graph.shortestPath("A", "F").toString().equals(
//            "[A, C, F]"
//        ));
//    }
//
//
//    /**
//     * Checks the distance/total weight cost from the vertex A to E.
//     */
//    @Test
//    public void testPathCostAtoE() {
//        assertTrue(graph.getPathCost("A", "E") == 6);
//    }
//
//    /**
//     * Checks the ordered sequence of data within vertices from the vertex
//     * A to E.
//     */
//    @Test
//    public void testPathAtoE() {
//        assertTrue(graph.shortestPath("A", "E").toString().equals(
//            "[A, C, B, E]"
//        ));
//    }
//
//    /**
//     * Checks the distance/total weight cost from the vertex B to F.
//     */
//    @Test
//    public void testPathCostBtoF() {
//        assertTrue(graph.getPathCost("B", "F") == 3);
//    }
//
//    /**
//     * Checks the Predessor to B along the shortest path from F to B.
//     */
//    @Test
//    public void testPredecessorFtoB() {
//        assertTrue(graph.dijkstrasShortestPath("F", "B").dataSequence.get(graph.dijkstrasShortestPath("F", "B").dataSequence.size()-2).equals("C"));
//    }
//
//    /**
//     * Checks the distance/total weight cost from the vertex E to B.
//     */
//    @Test
//    public void testPathCostEtoB() {
//        assertTrue(graph.getPathCost("E", "B") == 9);
//    }
//
//
//    /**
//     * Checks that method throws an exception when there is no path from start to end
//     */
//    @Test
//    public void testNullPointException() {
//        graph.removeEdge("C", "F");
//        assertThrows(NoSuchElementException.class, () -> { graph.shortestPath("A", "F");});
//    }



}
