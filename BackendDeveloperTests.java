// --== CS400 Project Three File Header ==--
// Name: Benjamin Miller
// CSL Username: benm
// Email: bhmiller3@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: None

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
      IShortestPath path = backend.getShortestPathTest(data, "start", "end");
    
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
      IShortestPath path = backend.getShortestPathTest(data, "start", "end");
      assertEquals(6, path.getVertices().size());
      assertEquals(1, path.getEdges().size());
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
      IShortestPath path = backend.getMinimumSpanningTreeTest(data, "start");
  
    // Verify the Functionality of the getShortestPath() Method
      assertEquals(6, path.getVertices().size());
      assertEquals(11, path.getEdges().size());
    
  }
  
}
