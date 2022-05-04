// --== CS400 Project Three File Header ==--
// Name: Benjamin Miller
// CSL Username: benm
// Email: bhmiller3@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: None

/**
 * Interface for the BEdge class which provides the graphical edges for the MadisonMap class
 * @author Benjamin Miller
 *
 */
public interface IEdge extends Comparable<IEdge> {
  /* POSSIBLE FIELDS
  private int weight; // corresponds to the distance between vertexA and vertexB
  private boolean visited; // Changed to true if included in MST formed by Engineer
  */
  
  // Gets the two vertices that this edge connects
  public IVertex getTarget();

  public IVertex getStart();
  
  // Returns the weight of the edge which represents distance in feet
  public int getWeight();
  
  // Modifier method for the "weight" field
  public void setWeight(int val);
  
}
