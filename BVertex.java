// --== CS400 Project Three File Header ==--
// Name: Benjamin Miller
// CSL Username: benm
// Email: bhmiller3@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: None

import java.util.LinkedList;
import java.util.List;

/**
 * Working implementation of the BIVertex interface which provides the necessary construction 
 * for the graphical vertices utilized within the IMadisonMap class.
 * @author Benjamin Miller
 */
public class BVertex implements BIVertex {
  private String name; // Name of the hotspot location
  private List<BIEdge> edges;  // List of all edges connected to the Vertex
  
  /**
   * Constructor which both instantiates the "name" field to its corresponding parameter and 
   * assigns index 0 of the coordinates array to the X-coordinate of the Vertex object and index 1 
   * of the array to the Y-coordinate of the Vertex object.
   * @param name denotes the desired name of the Vertex object
   */
  public BVertex(String name) {
    this.name = name;
    edges = new LinkedList<BIEdge>();
  }
  
  /**
   * Accessor method for the Vertex "name" field.
   * @return the String name of the Vertex object
   */
  @Override
  public String getName() {
    return this.name;
  }
  
  /**
   * Accessor method for the Vertex "edges" field.
   * @return a List<IEdge> object containing all edges connected to the Vertex object
   */
  @Override
  public List<BIEdge> getEdges() {
    return edges;
  }
  
  /**
   * Modifier method which enables one to add a new Edge object to the list of connected edges 
   * stored within the Vertex object.
   * @param target denotes the IVertex object to which the new Edge connects
   * @param weight denotes the desired weight of the newly added Edge object
   */
  @Override
  public void addConnectingEdge(BIVertex target, int weight) {
    edges.add(new BEdge(this, target, weight));
  }
}
