import java.util.List;

public interface IMadisonMapBackend {
  /* FIELDS (May Require Modification During Implementation)
   * private IMadisonMap map; // The actual MadisonMap object which denotes the entire collection 
   *                             of edges and vertices
   */
  
  /**
   * Utilizes the shortestPath() method implemented by the Algorithm Engineer to obtain the 
   * shortest graphical path between two IVertex objects.
   * @param vertices refers to a String array of length two, with index 0 denoting the String name 
   *        of the "start" IVertex object from which the user seeks to calculate a shortest path 
   *        on the IMadisonMap graph and index 1 denoting the "end" IVertex object to which the 
   *        route leads
   * @return a new IShortestPath object which internally includes two lists: one of IVertex objects 
   *         which form the shortest path between vertices "start" and "end" (inclusive) and the 
   *         other of IEdge objects which contains all edges from the initial graph which lie 
   *         along the path from the start to end vertices.
   */
  public IShortestPath getShortestPath(String[] vertices);
    // Ensure length of String array is 2; index 0 = start vertex, index 1 = end vertex
  
  /**
   * Utilizes methods implemented by the Algorithm Engineer to obtain the shortest graphical 
   * among a collection of IVertex objects.
   * @param vertices refers to a collection of String names of IVertex objects among which 
   *        the user seeks to calculate the shortest path on the IMadisonMapGraph.
   * @return a new IShortestPath object which internally includes two lists: one of IVertex objects 
   *         which form the shortest path among all vertices (inclusive) and the other of IEdge 
   *         objects which contains all edges from the initial graph which lie along the path 
   *         from the start to end vertices.
   */
  public List<IVertex> getMinimumSpanningTree(String[] vertices);
  
}
