// --== CS400 Project Three File Header ==--
// Name: Benjamin Miller
// CSL Username: benm
// Email: bhmiller3@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: None

/**
 * Working implementation of the BIEdge interface which provides the necessary construction 
 * for the graphical edges utilized within the IMadisonMap class.
 * @author Benjamin Miller
 */
public class BEdge implements BIEdge {
  private int weight; // corresponds to the distance between vertexA and vertexB
  private BIVertex[] vertices; // contains the two vertices that this edge connects
  private boolean visited; // Changed to true if included in MST formed by Engineer
  
  /**
   * Constructor which both initializes the "weight" field to its corresponding parameter and 
   * adds two vertices, a source (A) and target (B), as indices 0 and 1, respectively, of the 
   * internal BIVertex[] array.
   * @param A denotes the source IVertex object from which the Edge originates
   * @param B denotes the target IVertex object to which the Edge connects
   * @param weight denotes the weight of the Edge
   */
  public BEdge(BIVertex A, BIVertex B, int weight) {
    vertices = new BIVertex[] { A, B };
    this.weight = weight;
  }
  
  /**
   * Accessor method for the Edge "vertices" field.
   * @return an IVertex[] array denoting the two vertices connected by the Edge object (Note, 
   * index 0 of the array corresponds to the source IVertex object, while index 1 corresponds 
   * to the target IVertex object)
   */
  @Override
  public BIVertex[] getVertices() {
    return vertices;
  }
  
  /**
   * Modifier method which enables the user to edit the weight of the Edge object
   * @param val denotes the desired edge weight
   */
  public void setWeight(int val) {
    weight = val;
  }
  
  /**
   * Accessor method for the Edge "weight" field.
   * @return the int weight of the Edge object
   */
  @Override
  public int getWeight() {
    return weight;
  }
  
  /**
   * Modifier method which enables the user to toggle the "visited" state of the Edge object
   */
  @Override
  public void setVisited(boolean status) {
    visited = status;
  }
  
  /**
   * Accessor method for the Edge "visited" field.
   * @return true if the Edge proves is visited when constructing a shortest path, false otherwise
   */
  @Override
  public boolean isVisited() {
    return visited;
  }

  
}