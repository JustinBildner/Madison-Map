// --== CS400 Project Three File Header ==--
// Name: Benjamin Miller
// CSL Username: benm
// Email: bhmiller3@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: None

import java.util.LinkedList;
import java.util.List;

/**
 * Working implementation of the IShortestPath interface which contains two lists: one of vertices 
 * and the other of edges utilized along the shortest path between or among nodes; the purpose of 
 * the ShortestPath object is to delegate the responsibility of determining which edges are 
 * “active” along the shortest path from the Frontend to Backend Developer, thereby simplifying 
 * ease of access to these edges for the Frontend.
 * @author Benjamin Miller
 */
public class ShortestPath implements IShortestPath {
  
  private List<IVertex> vertices; // List of BIVertex objects included along the shortest path
  private List<IEdge> edges; // List of BIEdge objects included along the shortest path
  
  /**
   * Constructor of the ShortestPath class which accepts a list of IVertex objects along a 
   * computed shortest path as input. Utilizing the inputed list, the constructor then traverses 
   * the Edge lists stored in each Vertex and adds all "visited" edges to the "edges" List<Edge>
   * object.
   * @param vertices denotes a list of IVertex objects which constitute a computed shortest path
   */
  public ShortestPath(List<IVertex> vertices) {
    // Instantiate the List<IVertex> vertices and List<IEdge> edges fields
      this.vertices = vertices;
      edges = new LinkedList<>();
      
    // Traverse the list of vertices to access their individual lists of edges
      for(IVertex vertex : vertices) {
        // Obtain the edges of the current IVertex object
          List<IEdge> allEdges = vertex.getEdges();
        
        // Traverse the list of edges stored within the current IVertex object
          for(IEdge edge : allEdges) {
            /* If an edge proves "visited," that is, it is included along the shortest path, add 
             * the edge to the "edges" field. Finally, set the "visited" status of the edge to 
             * false to prevent interference with future shortest path computations
             */
            if(edge.isVisited()) {
              edges.add(edge);
              edge.setVisited(false);
            }
          }
      }
  }
  
  /**
   * Constructor of the ShortestPath class which accepts a list of both IVertex and IEdge objects 
   * along a computed shortest path as input.
   * @param vertices denotes a list of IVertex objects which constitute a computed shortest path
   * @param edges denotes a list of IEdge objects which constitute a computed shortest path
   */
  public ShortestPath(List<IVertex> vertices, List<IEdge> edges ) {
    this.vertices=vertices;
    this.edges = edges;
  }
  
  /**
   * Accessor method for the List<IVertex> "vertices" field.
   * @return a List<IVertex> objects included along the computer shortest path
   */
  @Override
  public List<IVertex> getVertices() {
    return vertices;
  }

  /**
   * Accessor method for the List<IEdge> "edges" field.
   * @return a List<IEdge> objects included along the computer shortest path
   */
  @Override
  public List<IEdge> getEdges() {
    return edges;
  }

}
