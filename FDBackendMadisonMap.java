// --== CS400 Project Three File Header ==--
// Name: Nate Colburn
// Email: ncolburn2@wisc.edu
// Team: BN
// TA: Sujitha Perumal
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.ArrayList;
import java.util.List;
public class FDBackendMadisonMap{

  /*
   * FIELDS (May Require Modification During Implementation) private IMadisonMap map; // The actual
   * MadisonMap object which denotes the entire collection of edges and vertices
   */

  /**
   * Utilizes the shortestPath() method implemented by the Algorithm Engineer to obtain the shortest
   * graphical path between two IVertex objects.
   * 
   * @param vertices refers to a String array of length two, with index 0 denoting the String name
   *                 of the "start" IVertex object from which the user seeks to calculate a shortest
   *                 path on the IMadisonMap graph and index 1 denoting the "end" IVertex object to
   *                 which the route leads
   * @return a new IShortestPath object which internally includes two lists: one of IVertex objects
   *         which form the shortest path between vertices "start" and "end" (inclusive) and the
   *         other of IEdge objects which contains all edges from the initial graph which lie along
   *         the path from the start to end vertices.
   */
  public FDShortestPath getShortestPath(String start, String end) {
    // Ensure length of String array is 2; index 0 = start vertex, index 1 = end vertex
    if(start == null || end == null)
      throw new NullPointerException();
    FDVertex mossHumanities = new FDVertex(new String("Moss Humanities"), new ArrayList<FDIEdge>(), 0, 0 );
    FDVertex bookstore = new FDVertex(new String("Bookstore"), new ArrayList<FDIEdge>(), 0, 0 );
    FDEdge stateSt = new FDEdge(1, new FDIVertex[] {bookstore}, "State Street");
    FDShortestPath shortestPath = new FDShortestPath();
    shortestPath.vertices.add(mossHumanities);
    shortestPath.vertices.add(bookstore);
    shortestPath.edges.add(stateSt);
    return shortestPath;

  }

  /**
   * Utilizes methods implemented by the Algorithm Engineer to obtain the shortest graphical among a
   * collection of IVertex objects.
   * 
   * @param vertices refers to a collection of String names of IVertex objects among which the user
   *                 seeks to calculate the shortest path on the IMadisonMapGraph.
   * @return a new IShortestPath object which internally includes two lists: one of IVertex objects
   *         which form the shortest path among all vertices (inclusive) and the other of IEdge
   *         objects which contains all edges from the initial graph which lie along the path from
   *         the start to end vertices.
   */
  public FDShortestPath getMinimumSpanningTree(String[] vertices) {
    if(vertices == null)
      throw new NullPointerException();
    ArrayList<FDVertex> listVertices = new ArrayList<FDVertex>();
    ArrayList<FDEdge> listEdges = new ArrayList<FDEdge>();
    FDVertex bookstore = new FDVertex(new String("Bookstore"), new ArrayList<FDIEdge>(), 0, 0 );
    FDVertex mossHumanities = new FDVertex(new String("Moss Humanities"), new ArrayList<FDIEdge>(), 0, 0 );
    FDVertex madisonMarket = new FDVertex(new String("Madison Market"), new ArrayList<FDIEdge>(), 0, 0 );
    FDVertex witteHall = new FDVertex(new String("Witte Hall"), new ArrayList<FDIEdge>(), 0, 0 );
    FDEdge stateSt = new FDEdge(1, new FDIVertex[] {bookstore}, "State Street");
    listVertices.add(bookstore);
    listVertices.add(mossHumanities);
    listVertices.add(madisonMarket);
    listVertices.add(witteHall);
    listEdges.add(stateSt);
    listEdges.add(stateSt);
    listEdges.add(stateSt);
    
    FDShortestPath shortestPath = new FDShortestPath();
    shortestPath.edges = listEdges;
    shortestPath.vertices = listVertices;
    return shortestPath;
  }
}

