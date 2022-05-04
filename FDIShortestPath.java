// --== CS400 Project Three File Header ==--
// Name: Nate Colburn
// Email: ncolburn2@wisc.edu
// Team: BN
// TA: Sujitha Perumal
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.List;

public interface FDIShortestPath {
  /* FIELDS
  public List<IVertex> vertices;
  public List<IEdge> edges;
  */
  public List<FDIVertex> getVertices();
  public List<FDIEdge> getEdges();
}
