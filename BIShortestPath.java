// --== CS400 Project Three File Header ==--
// Name: Benjamin Miller
// CSL Username: benm
// Email: bhmiller3@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: None

import java.util.List;

/**
 * Interface for the ShortestPath object which provides the necessary methods to implement
 * @author Benjamin Miller
 *
 */
public interface BIShortestPath {
  /* POSSIBLE FIELDS
  public List<IVertex> vertices;
  public List<IEdge> edges;
  */
  
  // Accessor method to return the list of vertices included in the calculated shortest path
  public List<BIVertex> getVertices();
  
  // Accessor method to return the list of edges included in the calculated shortest path
  public List<BIEdge> getEdges();
}
