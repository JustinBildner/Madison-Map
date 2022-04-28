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
  
  protected Hashtable<String, BIVertex> vertices; // holds graph verticies, key=data
  
  public BMadisonMap() {
    vertices = new Hashtable<>();
  }
  
  @Override
  public boolean insertVertex(String data) {
    vertices.put(data, new BVertex(data));
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
      BIVertex sourceVertex = this.vertices.get(source);
      BIVertex targetVertex = this.vertices.get(target);
      if(sourceVertex == null || targetVertex == null) 
          throw new IllegalArgumentException("Cannot add edge with vertices that do not exist");
      if(weight < 0) 
          throw new IllegalArgumentException("Cannot add edge with negative weight");
      // handle cases where edge already exists between these verticies
      for(BIEdge e : sourceVertex.getEdges())
          if(e.getVertices()[1] == targetVertex) {
              if(e.getWeight() == weight) return false; // edge already exists
              else e.setWeight(weight); // otherwise update weight of existing edge
              return true;
          }
      // otherwise add new edge to sourceVertex
      sourceVertex.addConnectingEdge(targetVertex,weight);
      return true;
  }

  @Override
  public boolean removeEdge(String source, String target) {
    // TODO Auto-generated method stub
    return false;
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
    for(BIVertex v : vertices.values()) {
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
    for(BIVertex v : vertices.values())
        edgeCount += v.getEdges().size();
    return edgeCount;
  }

  @Override
  public int getVertexCount() {
    return vertices.size();
  }

  @Override
  public BIShortestPath computeMinimumSpanningTree(String start) {
    List<BIVertex> verticesList = new LinkedList<>();
    List<BIEdge> edges = new LinkedList<>();
    for(BIVertex vertex : vertices.values()) {
      verticesList.add(vertex);
      edges.addAll(vertex.getEdges());
    }
    BShortestPath result = new BShortestPath(verticesList, edges);
    return result;
  }

  @Override
  public BIShortestPath computeShortestPath(BIVertex start, BIVertex end) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Hashtable<String, BIVertex> getVertices() {
    return vertices;
  }
  
}