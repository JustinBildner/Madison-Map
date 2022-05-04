// --== CS400 Project Three File Header ==--
// Name: Benjamin Miller
// CSL Username: benm
// Email: bhmiller3@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: None

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class BMadisonMap implements BIMadisonMap<String> {
  
  protected Hashtable<String, IVertex> vertices; // holds graph verticies, key=data
  
  public BMadisonMap(Hashtable<String, IVertex> vertices) {
    this.vertices = vertices;
  }
  
  @Override
  public boolean insertVertex(String data) {
    vertices.put(data, new Vertex(data));
    return true;
  }

  @Override
  public boolean removeVertex(String data) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean insertEdge(String source, String target, int weight) {
      if(source == null || target == null) 
          throw new NullPointerException("Cannot add edge with null source or target");
      IVertex sourceVertex = this.vertices.get(source);
      IVertex targetVertex = this.vertices.get(target);
      if(sourceVertex == null || targetVertex == null) 
          throw new IllegalArgumentException("Cannot add edge with vertices that do not exist");
      if(weight < 0) 
          throw new IllegalArgumentException("Cannot add edge with negative weight");
      // handle cases where edge already exists between these verticies
      for(IEdge e : sourceVertex.getEdges())
          if(e.getTarget() == targetVertex) {
              if(e.getWeight() == weight) return false; // edge already exists
              else e.setWeight(weight); // otherwise update weight of existing edge
              return true;
          }
      // otherwise add new edge to sourceVertex
      sourceVertex.addConnectingEdge(targetVertex,weight);
      return true;
  }
  
  /*
  @Override
  public boolean removeEdge(String source, String target) {
    // TODO Auto-generated method stub
    return false;
  }*/
  /**
   * Remove an edge from the graph.
   * 
   * @param source the data item contained in the source vertex for the edge
   * @param target the data item contained in the target vertex for the edge
   * @return true if the edge could be removed, false if it was not in the graph
   * @throws IllegalArgumentException if either source or target or both are not in the graph
   * @throws NullPointerException if either source or target or both are null
   */
  public boolean removeEdge(String source, String target) {
      if(source == null || target == null) throw new NullPointerException("Cannot remove edge with null source or target");
      IVertex sourceVertex = this.vertices.get(source);
      IVertex targetVertex = this.vertices.get(target);
      if(sourceVertex == null || targetVertex == null) throw new IllegalArgumentException("Cannot remove edge with vertices that do not exist");
      // find edge to remove
      IEdge removeEdge = null;
      for(IEdge e : sourceVertex.getEdges())
          if(e.getTarget() == targetVertex) 
              removeEdge = e;
      if(removeEdge != null) { // remove edge that is successfully found                
          sourceVertex.getEdges().remove(removeEdge);
          return true;
      }
      return false; // otherwise return false to indicate failure to find
  }

  @Override
  public boolean containsVertex(String data) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean containsEdge(String source, String target) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int getWeight(String source, String target) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<String> shortestPath(String start, String end) {
    List<String> locationNames = new LinkedList<>();
    for(IVertex v : vertices.values()) {
      locationNames.add(v.getName());
    }
    
    return locationNames;
  }

  @Override
  public int getPathCost(String start, String end) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int getEdgeCount() {
    int edgeCount = 0;
    for(IVertex v : vertices.values())
        edgeCount += v.getEdges().size();
    return edgeCount;
  }

  @Override
  public int getVertexCount() {
    return vertices.size();
  }

  @Override
  public IShortestPath computeMinimumSpanningTree(String start) {
    List<IVertex> verticesList = new LinkedList<>();
    List<IEdge> edges = new LinkedList<>();
    for(IVertex vertex : vertices.values()) {
      verticesList.add(vertex);
      edges.addAll(vertex.getEdges());
    }
    ShortestPath result = new ShortestPath(verticesList, edges);
    return result;
  }

  @Override
  public IShortestPath computeShortestPath(IVertex start, IVertex end) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Hashtable<String, IVertex> getVertices() {
    return vertices;
  }
  
}
