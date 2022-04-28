// --== CS400 Project Three File Header ==--
// Name: Benjamin Miller
// CSL Username: benm
// Email: bhmiller3@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: None

import java.util.LinkedList;
import java.util.List;

/**
 * Placeholder class which performs the role of filling and returning a list of IVertex objects 
 * to simulate the List<IVertex> object compiled by the Data Wrangler in the final implementation 
 * of the project.
 * @author Benjamin Miller
 *
 */
public class BMapLoader implements BIMapLoader {
  
  /**
   * Constructs a List<BIVertex> object which simulates the creation of the list of Madison 
   * locations compiled by the Data Wrangler.
   * @return a List<BIVertex> object which contains the desired vertices to include in the 
   *         working implementation of the IMadisonMap class
   */
  @Override
  public List<BIVertex> loadMap() {
    // Develop the Graph Provided for the Shortest Path Activity; Simulates the Inputting of Data
      // Instantiate Vertices A-F
        BVertex a = new BVertex("A");
        BVertex b = new BVertex("B");
        BVertex c = new BVertex("C");
        BVertex d = new BVertex("D");
        BVertex e = new BVertex("F");
        BVertex f = new BVertex("E");
      
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
      List<BIVertex> vertices = new LinkedList<>();
      vertices.add(a);
      vertices.add(b);
      vertices.add(c);
      vertices.add(d);
      vertices.add(e);
      vertices.add(f);
      
    // Return the List of IVertex objects
      return vertices;
  }

}
