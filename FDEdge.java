// --== CS400 Project Three File Header ==--
// Name: Nate Colburn
// Email: ncolburn2@wisc.edu
// Team: BN
// TA: Sujitha Perumal
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

public class FDEdge implements FDIEdge {
  private int weight; // corresponds to the distance between vertexA and vertexB
  private FDIVertex[] vertices; // contains the two vertices that this edge connects
  private boolean visited; // Changed to true if included in MST formed by Engineer
  private String name;
  
  public FDEdge(int weight, FDIVertex[] vertices, String name) {
    this.weight = weight;
    this.vertices = vertices;
    this.name = name;
  }
  
  //Returns the vertices that the edge connects as an array
  @Override
  public FDIVertex[] getVertices() {
    return vertices;
  }
  
  // Returns the Weight of the Edge
  @Override
  public int getWeight() {
    return weight;
  }
  
  // True if included in shortest path, false otherwise
  @Override
  public boolean isVisited() {
    return visited;
  }
  
  public String getName() {
    return name;
  }
}
  

