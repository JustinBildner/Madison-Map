// --== CS400 Project Three File Header ==--
// Name: Benjamin Miller
// CSL Username: benm
// Email: bhmiller3@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: None

import java.util.LinkedList;
import java.util.List;

/**
 * Working implementation of the IMadisonMapBackend interface which constructs a MadisonMap 
 * graph by inserting the vertex and edge data compiled by the Data Wrangler through the 
 * MapLoader class. Additionally, the class implements two shortest path methods designed to 
 * aid the Frontend Developer in accessing the shortest paths between or among nodes.
 * @author Benjamin Miller
 * @version 1.0
 */
public class MadisonMapBackend implements IMadisonMapBackend {
  protected BIMadisonMap<String> map; // Corresponds to the working map of Madison
  
  /**
   * Single argument constructor of the MadisonMapBackend class which initializes the IMadisonMap 
   * "map" field by inserting the vertex and edge data collected by the Data Wrangler.
   * @param mapData refers to an IMapLoader object which internally contains a List<IVertex> 
   *        object constructed by the Data Wrangler to contain all desired graph vertices for the 
   *        working map of Madison
   */
  public MadisonMapBackend(BIMapLoader mapData) {
    // Initialize the "map" Field Through the Hashtable of Vertices
    if(mapData == null) {
      throw new IllegalArgumentException();
    }
    map = new BMadisonMap(mapData.loadMap());
  }
  
  /**
   * Utilizes the shortestPath() method implemented by the Algorithm Engineer to obtain the 
   * shortest graphical path between two IVertex objects.
   * @param start refers to the String name of the "start" IVertex object from which the user 
   *        seeks to calculate a shortest path on the IMadisonMap graph
   * @param end denotes the "end" IVertex object to which the desired shortest path leads
   * @return a new IShortestPath object which internally includes two lists: one of IVertex objects 
   *         which form the shortest path between vertices "start" and "end" (inclusive) and the 
   *         other of IEdge objects which contains all edges from the initial graph which lie 
   *         along the path from the start to end vertices; if the program fails to compute the 
   *         shortest path between the desired vertices, the method will return "null"
   */
  @Override
  public IShortestPath getShortestPath(String start, String end) {
    // Retrieve the String list of location names included along the shortest path
      List<String> locationNames = map.shortestPath(start, end);
      
    /* Convert the list of String names to a list of IVertex objects by accessing the MadisonMap
     * Hashtable<String, IVertex> field; note, each location name functions as the "key" which 
     * maps to its corresponding IVertex "value"
     */
    List<IVertex> includedVertices = new LinkedList<>();
    if(locationNames != null) {
      for(String name : locationNames) {
        includedVertices.add(map.getVertices().get(name));
      }
      // Construct and return an IShortestPath object from the computer IVertex list
        return new ShortestPath(includedVertices);
    }
    return null; // Return null if not shortest path located
  }

  /**
   * Utilizes the computeMinimumSpanningTree() method implemented by the Algorithm Engineer to 
   * obtain the shortest graphical path from a particular IVertex object to all other vertices 
   * on the IMadisonMap graph.
   * @param start refers to the String name of the "start" IVertex object from which the user 
   *        seeks to calculate the shortest path to all other vertices on the IMadisonMap graph
   * @return a new IShortestPath object which internally includes two lists: one of IVertex objects 
   *         which form the shortest path among all vertices (inclusive) and the other of IEdge 
   *         objects which contains all edges from the initial graph which lie along the path 
   *         from the start to end vertices.
   */
  @Override
  public IShortestPath getMinimumSpanningTree(String start) {
    return map.computeMinimumSpanningTree(start);
  }
  
  
}
