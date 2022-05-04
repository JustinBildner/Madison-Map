// --== CS400 Project Three File Header ==--
// Name: Benjamin Miller
// CSL Username: benm
// Email: bhmiller3@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: None

import java.util.Hashtable;
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
  public Hashtable<String, IVertex> loadMap() {
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
      
    // Return the List of IVertex objects
      return vertices;
  }

}
