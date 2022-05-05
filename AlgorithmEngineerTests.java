import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Tests the implementation of MadisonMap for
 * Project Three: the implementation of Dijsktra's Shortest Path algorithm.
 * @author justinbildner
 */
public class AlgorithmEngineerTests {

    private MadisonMap graph;
    private MadisonMap map;

    /**
     * Instantiate example graph.
     */
    @BeforeEach
    public void createGraph() {
        try {
            IMapLoader mapLoader = new MapLoader();
            Hashtable<String, IVertex> locations = new Hashtable<>();
            map = new MadisonMap(mapLoader.loadMap());
        }
        catch(FileNotFoundException e)
        {
            System.out.println("You are a dumbass");
        }



        Hashtable<String, IVertex> vertices = new Hashtable<>();
        graph = new MadisonMap(vertices);
        // insert vertices A-F
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");
        graph.insertVertex("G");
        // insert edges from Week 11. Shortest Path Activity

        graph.insertEdge("A","F",10);
        graph.insertEdge("A","B",28);
        graph.insertEdge("B","C",16);
        graph.insertEdge("B","G",14);
        graph.insertEdge("F","E",25);
        graph.insertEdge("E","G",24);
        graph.insertEdge("G","D",18);
        graph.insertEdge("E","D",22);
        graph.insertEdge("D","C",12);

        graph.insertEdge("F","A",10);
        graph.insertEdge("B","A",28);
        graph.insertEdge("C","B",16);
        graph.insertEdge("G","B",14);
        graph.insertEdge("E","F",25);
        graph.insertEdge("G","E",24);
        graph.insertEdge("D","G",18);
        graph.insertEdge("D","E",22);
        graph.insertEdge("C","D",12);
    }

    /**
     * Checks the list of Vertices in the ShortestPath object making sure they are correct for the
     * Minimum spanning tree computed using Primm's starting at Vertex A
     */
    @Test
    public void MinTreeA() {
        assertTrue(graph.minTreeVert("A").toString().equals(
            "[A, F, E, D, C, B, G]"
        ));
    }


    /**
     * Checks the list of Edges in the ShortestPath object making sure they are correct for the
     * Minimum spanning tree computed using Primm's starting at Vertex A
     */
    @Test
    public void MinTreeEdgeA() {
        assertTrue(graph.minTreeEdge("A").toString().equals(
            "[AF, FE, ED, DC, CB, BG]"
        ));
    }

    /**
     * Checks the list of Vertices in the ShortestPath object making sure they are correct for the
     * Minimum spanning tree computed using Primm's starting at Vertex G
     */
    @Test
    public void MinTreeG() {
//        System.out.println()
        assertTrue(graph.minTreeVert("G").toString().equals(
            "[G, B, C, D, E, F, A]"
        ));
    }

    /**
     * Checks the list of Vertices in the ShortestPath object making sure they are correct for the
     * Minimum spanning tree computed using Primm's starting at Vertex C
     */
    @Test
    public void MinTreeC() {
        //        System.out.println()
        assertTrue(graph.minTreeVert("C").toString().equals(
            "[C, D, B, G, E, F, A]"
        ));
    }

    /**
     * Checks that method throws an exception when there is no starting vertex
     */
    @Test
    public void testNullPointException() {
        graph.removeVertex("C");
        assertThrows(NoSuchElementException.class, () -> { graph.minTreeVert("C");});
    }

    /**
     * Checks the size of the list of edges and vertices in the ShortestPath object from the
     * Minimum spanning tree computed using Primm's starting at an example location
     * of State Street Brats
     */
    @Test
    public void testMadisonMinTreeSize() {
        assertTrue(map.minTreeVert("State Street Brats").size() == 22);
        assertTrue(map.minTreeEdge("State Street Brats").size() == 21);
    }

    /**
     * Checks the list of Vertices in the ShortestPath object making sure that all vertices in the
     * map are there and only once in the correct order for the
     * Minimum spanning tree computed using Primm's starting at Danny's Pub
     */
    @Test
    public void testMadisonMinTreeDanny() {
                assertTrue(map.minTreeVert("Danny's Pub").toString().equals("[Danny's Pub, Le C's, Parthenon Gyros, "
                    + "Ian's Pizza, Madison Concourse Hotel, Wisconsin State Capitol, Basset Street Brunch, Basset Street Brunch, "
                    + "Tornado Stake House, RED, Washington & Broom, State Street Brats, University Book Store, Langdon & Lake, "
                    + "Lowell Center, Memorial Union, Bascom Hill, Chadbourne Hall, Washington & Basset, Washington & Basset, "
                    + "Nicholas Recreation Center, Witte Residence Hall]"));
    }

    /** This is a tester for the DataWrangler's MapLoader making sure that a hashtable containing all 22 vertices is computed
     *
     */
    @Test
    public void testForAllVertices() {
        MapLoader ml = new MapLoader();
        try {
            Hashtable<String, IVertex> vertices = ml.loadMap();
            assertEquals(vertices.size(), 22, "Improper number of vertices loaded");
        } catch (Exception e) {
            fail("An Exception with the following message was thrown: " + e.getMessage());
        }
    }

    /**
     * This is a tester for the DataWrangler's MapLoader ensuring that all the Edges loaded for two random vertices chosen
     * which happens to be Lake & University and Ian's Pizza
     */
    @Test
    void allEdgesLoadedForRandomVertex() {
        MapLoader ml = new MapLoader();
        try {
            Hashtable<String, IVertex> vertices = ml.loadMap();
            assertEquals(vertices.get("Lake & University").getEdges().size(), 2,
                "Improper number of vertices loaded");
            assertEquals(vertices.get("Ian's Pizza").getEdges().size(), 5,
                "Improper number of vertices loaded");
        } catch (Exception e) {
            fail("An Exception with the following message was thrown: " + e.getMessage());
        }

    }
}
