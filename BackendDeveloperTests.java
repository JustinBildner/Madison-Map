// --== CS400 Project Three File Header ==--
// Name: Benjamin Miller
// CSL Username: benm
// Email: bhmiller3@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: None

import java.util.Hashtable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

public class BackendDeveloperTests {
  
  /**
   * Verifies the functionality of the MadisonMapBackend constructor when provided valid input.
   * 
   * @return true if functionality is verified, false otherwise
   */
  @Test
  public void testValidConstructorInput() {
    // Prepare Data to Instantiate a MadisonMapBackend Object
      IMapLoader data = new BMapLoader();
    
    // Create MadisonMapBackend Object
      MadisonMapBackend backend = new MadisonMapBackend(data, "test");
    
    // Verify Correct Traversal of Inputed Data to Create the IMadisonMap Object
      assertEquals(6, backend.map.getVertexCount());
      assertEquals(11, backend.map.getEdgeCount());
  }
  
  /**
   * Verifies the functionality of the MadisonMapBackend constructor when provided invalid input.
   * 
   * @return true if functionality is verified, false otherwise
   */
  @Test
  public void testInvalidConstructorInput() {
    boolean passed = false;
    try {
      // Create a MadisonMapBackend Object with a Null Parameter
      MadisonMapBackend backend = new MadisonMapBackend(null);
    }
    catch(IllegalArgumentException e) {
      passed = true; // Set "passed" to true if exception caught, otherwise "passed" remains false
    }
  
    // Verify the Functionality of the Constructor Illegal Argument Handling
      assertTrue(passed);
  }
  
  /**
   * Verifies the functionality of the MadisonMapBackend getShortestPath() method prior to 
   * setting any edges as included along the computed shortest path.
   * 
   * @return true if functionality is verified, false otherwise
   */
  @Test
  public void testGetShortestPath() {
    // Prepare Data to Instantiate a MadisonMapBackend Object
      IMapLoader data = new BMapLoader();
    
    // Create MadisonMapBackend Object and Invoke the getShortestPath() Method
      MadisonMapBackend backend = new MadisonMapBackend(data, "test");
      IShortestPath path = backend.getShortestPathTest("start", "end");
    
    // Verify the Functionality of the getShortestPath() Method
      assertEquals(6, path.getVertices().size());
      assertEquals(1, path.getEdges().size());
  }
  
  /**
   * Verifies the functionality of the MadisonMapBackend getShortestPath() method following 
   * modifications to the included edges along the computed shortest path.
   * 
   * @return true if functionality is verified, false otherwise
   */
  @Test
  public void testModifiedShortestPath() {
    // Prepare Data to Instantiate a MadisonMapBackend Object
      IMapLoader data = new BMapLoader();
  
    // Create MadisonMapBackend Object
      MadisonMapBackend backend = new MadisonMapBackend(data, "test");
      
    // Remove Edges to Ensure Correct New Path Created
      backend.map.getVertices().get("A")
        .addConnectingEdge(backend.map.getVertices().get("F"), 1);
      
    // Invoke the getShortestPath() Method and Verify its Functionality
      IShortestPath path = backend.getShortestPathTest("start", "end");
      assertEquals(6, path.getVertices().size());
      assertEquals(2, path.getEdges().size());
  }
  
  /**
   * Verifies the functionality of the computeMinimumSpanningTree() method when provided valid 
   * input.
   * 
   * @return true if functionality is verified, false otherwise
   */
  @Test
  public void testGetMinimumSpanningTree() {
    // Prepare Data to Instantiate a MadisonMapBackend Object
      IMapLoader data = new BMapLoader();
  
    // Create MadisonMapBackend Object and Invoke the getShortestPath() Method
      MadisonMapBackend backend = new MadisonMapBackend(data, "test");
      IShortestPath path = backend.getMinimumSpanningTreeTest("start");
  
    // Verify the Functionality of the getShortestPath() Method
      assertEquals(6, path.getVertices().size());
      assertEquals(11, path.getEdges().size());
    
  }
  /**
   * Verifies the functionality of the MadisonMapBackend getShortestPath() method when utilizing 
   * the actual MadisonMap and MapLoader classes.
   * 
   * @return true if functionality is verified, false otherwise
   */
  @Test
  public void integrationTestGetShortestPath() {
   // Prepare Data to Instantiate a MadisonMapBackend Object
      IMapLoader data = new MapLoader();
    
    // Create MadisonMapBackend Object and Invoke the getShortestPath() Method
      MadisonMapBackend backend = new MadisonMapBackend(data);
      IShortestPath path = backend.getShortestPath("RED", "Ian's Pizza");
    
    // Verify the Functionality of the getShortestPath() Method
      assertEquals(2, path.getVertices().size());
      assertEquals(1, path.getEdges().size());
  }
  
  /**
   * Verifies the functionality of the MadisonMapBackend computeMinimumSpanningTree() method 
   * when utilizing the actual MadisonMap and MapLoader classes.
   * 
   * @return true if functionality is verified, false otherwise
   */
  @Test
  public void integrationTestGetMinimumSpanningTree() {
    // Prepare Data to Instantiate a MadisonMapBackend Object
      IMapLoader data = new MapLoader();
  
    // Create MadisonMapBackend Object and Invoke the getShortestPath() Method
      MadisonMapBackend backend = new MadisonMapBackend(data);
      IShortestPath path = backend.getMinimumSpanningTree("Bascom Hill");
  
    // Verify the Functionality of the getShortestPath() Method
      assertEquals(22, path.getVertices().size());
      assertEquals(21, path.getEdges().size());
    
  } 
/**
   * Verifies the functionality of the Algorithm Engineer's MadisonMap 
   * getMinimumSpanningTree() method when utilizing a hard coded hash table.
   * 
   * @return true if functionality is verified, false otherwise
   */
  @Test
  public void AlgorithmEngineerMST() {
    // Develop the Graph Provided for the Shortest Path Activity; Simulates the Inputting of Data
      // Instantiate Vertices A-F
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
    
      // Connect Vertices Through the Specified Edges
        a.addConnectingEdge(b, 6);
        a.addConnectingEdge(c, 2);
        a.addConnectingEdge(d, 5);
        b.addConnectingEdge(e, 1);
        b.addConnectingEdge(c, 2);
        c.addConnectingEdge(b, 3);
        c.addConnectingEdge(f, 1);
        d.addConnectingEdge(e, 3);
        e.addConnectingEdge(a, 4);
        f.addConnectingEdge(a, 1);
        f.addConnectingEdge(d, 1);
      
    // Develop a List of the IVertex Objects in the Graph
      Hashtable<String, IVertex> vertices = new Hashtable<>();
      vertices.put("A", a);
      vertices.put("B", b);
      vertices.put("C", c);
      vertices.put("D", d);
      vertices.put("E", e);
      vertices.put("F", f);
      
    // Construct a MadisonMap Object from the Hard Coded Hashtable
      MadisonMap map = new MadisonMap(vertices);
    
    // Verify the functionality of getMinimumSpanningTree()
      IShortestPath path = map.computeMinimumSpanningTree("A");
      assertEquals(6, path.getVertices().size());
      assertEquals(5, path.getEdges().size());
      
  }
  
  /**
   * Verifies the functionality of the Algorithm Engineer's MadisonMap getPathCost() method when 
   * utilizing a hard coded hash table.
   * 
   * @return true if functionality is verified, false otherwise
   */
  @Test
  public void AlgorithmEngineerShortestPath() {
    // Develop the Graph Provided for the Shortest Path Activity; Simulates the Inputting of Data
      // Instantiate Vertices A-F
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
    
      // Connect Vertices Through the Specified Edges
        a.addConnectingEdge(b, 6);
        a.addConnectingEdge(c, 2);
        a.addConnectingEdge(d, 5);
        b.addConnectingEdge(e, 1);
        b.addConnectingEdge(c, 2);
        c.addConnectingEdge(b, 3);
        c.addConnectingEdge(f, 1);
        d.addConnectingEdge(e, 3);
        e.addConnectingEdge(a, 4);
        f.addConnectingEdge(a, 1);
        f.addConnectingEdge(d, 1);
      
    // Develop a List of the IVertex Objects in the Graph
      Hashtable<String, IVertex> vertices = new Hashtable<>();
      vertices.put("A", a);
      vertices.put("B", b);
      vertices.put("C", c);
      vertices.put("D", d);
      vertices.put("E", e);
      vertices.put("F", f);
      
    // Construct a MadisonMap Object from the Hard Coded Hashtable
      MadisonMap map = new MadisonMap(vertices);
    
    // Verify the functionality of getMinimumSpanningTree()
      assertEquals(1, map.getPathCost("F", "A"));
  }

}
