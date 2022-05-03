// --== CS400 Project Three File Header ==--
// Name: Benjamin Miller
// CSL Username: benm
// Email: bhmiller3@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: None

import java.util.List;

/**
 * Interface for the BVertex class which provides the graphical vertices for the MadisonMap class
 * @author Benjamin Miller
 *
 */
public interface IVertex {
  /* POSSIBLE FIELDS
   * private String name; // Name of the hotspot location
   * private List<IEdge> edges;  // List of all edges connected to the Vertex
   */
  
  // Returns the location name of the IVertex object
  public String getName();

  // Returns the list of BIEdge objects connected to the vertex
  public List<IEdge> getEdges();
  
  // Modifier method which enables one to add a new BIEdge to the list of connected edges
  public void addConnectingEdge(IVertex target, int weight);
}
