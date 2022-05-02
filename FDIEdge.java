// --== CS400 Project Three File Header ==--
// Name: Nate Colburn
// Email: ncolburn2@wisc.edu
// Team: BN
// TA: Sujitha Perumal
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

public interface FDIEdge {
  /* FIELDS
  private int weight; // corresponds to the distance between vertexA and vertexB
  private IVertex[] vertices; // contains the two vertices that this edge connects
  private Vertex vertexB; // Another vertex that the edge connects
  private boolean visited = false; // Changed to true if included in MST formed by Engineer
  */
  public FDIVertex[] getVertices(); // Gets the two vertices that this edge connects
  public int getWeight(); // Returns the weight of the edge which represents distance in feet
  public boolean isVisited(); // Returns true if the node has been visited; false otherwise
  public String getName();
}
