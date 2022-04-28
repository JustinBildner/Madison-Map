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
      BIMapLoader data = new BMapLoader();
    
    // Create MadisonMapBackend Object
      MadisonMapBackend backend = new MadisonMapBackend(data);
    
    // Verify Correct Traversal of Inputed Data to Create the IMadisonMap Object
      assertEquals(backend.map.getVertexCount(), 6);
      assertEquals(backend.map.getEdgeCount(), 11);
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
      BIMapLoader data = new BMapLoader();
    
    // Create MadisonMapBackend Object and Invoke the getShortestPath() Method
      MadisonMapBackend backend = new MadisonMapBackend(data);
      BIShortestPath path = backend.getShortestPath("start", "end");
    
    // Verify the Functionality of the getShortestPath() Method
      assertEquals(path.getVertices().size(), 6);
      assertEquals(path.getEdges().size(), 0);
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
      BIMapLoader data = new BMapLoader();
  
    // Create MadisonMapBackend Object
      MadisonMapBackend backend = new MadisonMapBackend(data);
      
    // Alter the "visited" Status of All Edges Stored in the IMadisonMap Object
      for(BIVertex vertex : backend.map.getVertices().values()) { // Traverse vertices Hashtable
        for(BIEdge edge : vertex.getEdges()) { // Traverse each vertex "edges" list
          edge.setVisited(true); // Set each edge as visited
        }
      }
      
    // Invoke the getShortestPath() Method and Verify its Functionality
      BIShortestPath path = backend.getShortestPath("start", "end");
      assertEquals(path.getVertices().size(), 6);
      assertEquals(path.getEdges().size(), 11);
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
      BIMapLoader data = new BMapLoader();
  
    // Create MadisonMapBackend Object and Invoke the getShortestPath() Method
      MadisonMapBackend backend = new MadisonMapBackend(data);
      BIShortestPath path = backend.getMinimumSpanningTree("start");
  
    // Verify the Functionality of the getShortestPath() Method
      assertEquals(path.getVertices().size(), 6);
      assertEquals(path.getEdges().size(), 11);
    
  }
  
}
