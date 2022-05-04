// --== CS400 Project Three File Header ==--
// Name: Benjamin Miller
// CSL Username: benm
// Email: bhmiller3@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: None

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
  public IShortestPath getShortestPath(String start, String end);
    // Ensure length of String array is 2; index 0 = start vertex, index 1 = end vertex
  
  /**
   * Utilizes methods implemented by the Algorithm Engineer to obtain the shortest graphical path
   * among a collection of IVertex objects.
   * @param vertices refers to a collection of String names of IVertex objects among which 
   *        the user seeks to calculate the shortest path on the IMadisonMapGraph.
   * @return a new IShortestPath object which internally includes two lists: one of IVertex objects 
   *         which form the shortest path among all vertices (inclusive) and the other of IEdge 
   *         objects which contains all edges from the initial graph which lie along the path 
   *         from the start to end vertices.
   */
  public IShortestPath getMinimumSpanningTree(String start);
  
}
