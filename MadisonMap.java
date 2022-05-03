import java.util.*;

public class MadisonMap<String> implements IMadisonMap<String> {

    /** Computes Minimum Spanning Tree using Primm's Algorithm
     *
     * @param start data for the start vertex
     * @return ShortestPath object which contains a list of vertices and edges traversed
     */
    @Override public ShortestPath computeMinimumSpanningTree(String start)
    {
        if(!containsVertex(start)){
            System.out.println("Yes broken");
            throw new NoSuchElementException();
        }


        //Priority Queue that tracks the Edges needed to be visited
        PriorityQueue<IEdge> pq = new PriorityQueue<IEdge>();
        List<IVertex> visited = new ArrayList<>();
        List<IEdge> edgesTraversed = new ArrayList<>();

        IEdge tE = new Edge(vertices.get(start), vertices.get(start), 0);

        for(int i = 0; i < tE.getTarget().getEdges().size(); i++){
                pq.add(tE.getTarget().getEdges().get(i));
            }

        visited.add(tE.getTarget());

        //While loop until all vertices are found
        while(edgesTraversed.size() < getVertexCount()-1){

            tE = pq.poll();

            //Go through every edge that is encounters checking to see if it should be added to Priority Queue
            for(int i = 0; i < tE.getTarget().getEdges().size(); i++){
                if(!visited.contains(((Edge) tE.getTarget().getEdges().get(i)).getTarget())){
                    pq = checkReplace(pq, tE.getTarget().getEdges().get(i));
                }
            }

            //After a vertex has been visited and all its connecting vertices discovered it's added to the list to not be looked at again
            visited.add(tE.getTarget());
            edgesTraversed.add(tE);

        }
        return new ShortestPath(visited, edgesTraversed);
    }

    /** Helper method for computeMinimumSpanningTree that checks whether the edge in the Priority
     * Queue should be just added or replace another within the queue
     *
     * @param pq Priority Queue from computeMinimumSpanningTree
     * @param newEdge New Edge from computeMinimumSpanningTree that's looking to insert
     * @return changes priority queue
     */
    public PriorityQueue<IEdge> checkReplace(PriorityQueue<IEdge> pq, IEdge newEdge){

        //iterate through nodes in priority queue and update the key for the vertex
        Iterator it = pq.iterator();
        boolean add = false;
        boolean remove = false;
        IEdge toRemove = null;

        while (it.hasNext()) {
            IEdge edge = (IEdge) it.next();
            if(newEdge.getTarget() == edge.getTarget()) {
                if (newEdge.compareTo(edge) < 0) {
                    toRemove = edge;
                    remove = true;
                    add = true;
                }
                break;
            }
            else{
                add = true;
            }
        }
        if(add)
            pq.add(newEdge);
        if(remove)
            pq.remove(toRemove);

        return pq;
    }


    /**Method that helps with testing that gets the Vertex List from the ShortestPath object gotten
     * from computing the minimum spanning tree and converts it into data that can be turned into a string
     * representation
     *
     * @param start starting node
     * @return list of string data
     */
    public List<String> minTreeVert(String start) {
        List<IVertex> vertices = computeMinimumSpanningTree(start).getVertices();
        List<String> data = new ArrayList<>();
        for(IVertex v: vertices)
        {
            data.add((String)v.getName());
        }
        return data;
    }

    /**Method that helps with testing that gets the Edges Traversed List from the ShortestPath object gotten
     * from computing the minimum spanning tree and converts it into data that can be turned into a string
     * representation
     *
     * @param start starting node
     * @return list of string data
     */
    public List<String> minTreeEdge(String start) {
        List<IEdge> edges = computeMinimumSpanningTree(start).getEdges();
        List<String> data = new ArrayList<>();

        for (int i = 0; i < edges.size(); i++) {
//            String s = (String) (edges.get(i)).getStart().getName();
//
//            String e = (String) (edges.get(i)).getTarget().getName();
            data.add((String) ((edges.get(i)).getStart().getName() + (edges.get(i)).getTarget().getName()));
        }


        return data;
    }

    /**
     * Uses Dijkstra's shortest path algorithm to find and return the shortest path
     * between two vertices in this graph: start and end. This path contains an ordered list
     * of the data within each node on this path, and also the distance or cost of all edges
     * that are a part of this path.
     * @param start data item within first node in path
     * @param end data item within last node in path
     * @return the shortest path from start to end, as computed by Dijkstra's algorithm
     * @throws NoSuchElementException when no path from start to end can be found,
     *     including when no vertex containing start or end can be found
     */
    public Path dijkstrasShortestPath(String start, String end) {
        //Start or End is null or they don't exist within the graph
        if(start == null || end == null || containsVertex(start) == false || containsVertex(end) ==false)
            throw new NoSuchElementException();

        //First path initialization which only contains the start vertex
        Path tP = new Path(vertices.get(start));


        //Priority Queue that tracks the paths visited so far
        PriorityQueue<Path> pq = new PriorityQueue<Path>();

        //Add the first path to the priority queue
        pq.add(tP);

        //List of vertices visited to keep track
        List<IVertex> visited = new ArrayList<>();

        Path eTP;

        //While loop until the shortest path found between start and end is found
        while(pq.isEmpty() == false){

            //End vertex has been found
            if(tP.end.getName().equals(end)) {
//                tP.visited = visited;
                return tP;
            }

            //Go through every edge that is encounters checking to see if shortest path to vertices has been found yet
            for(int i = 0; i < tP.end.getEdges().size(); i++){
                if(!visited.contains((tP.end.getEdges().get(i)).getTarget())){
                    pq.add(new Path(tP, tP.end.getEdges().get(i)));
                }
            }

            //After a vertex has been visited and all its connecting vertices discovered it's added to the list to not be looked at again
            visited.add(tP.end);

            //Change temp path to the shortest path from the priority queue
            eTP = tP;
            tP = pq.poll();
//            for(int i = 0; i < tP.end.getEdges().size(); i++){
//                if(tP.end == ((Edge)eTP.end.getEdges().get(i)).target){
//                    pq.add(new Path(tP, (Edge) tP.end.getEdges().get(i)));
//                }
//            }

        }
        //When there is no path between the start and end nodes then NoSuchElementException will be thrown
        throw new NoSuchElementException();
    }

    public Hashtable<String, IVertex> vertices; // holds graph verticies, key=data
    public MadisonMap() {
        vertices = new Hashtable<>();
    }

    public Hashtable<String, IVertex> getVertices()
    {
        return this.vertices;
    }

    /**
     * Insert a new vertex into the graph.
     *
     * @param data the data item stored in the new vertex
     * @return true if the data can be inserted as a new vertex, false if it is
     *     already in the graph
     * @throws NullPointerException if data is null
     */
    public boolean insertVertex(String data) {
        if(data == null)
            throw new NullPointerException("Cannot add null vertex");
        if(vertices.containsKey(data)) return false; // duplicate values are not allowed
        vertices.put(data, new Vertex((java.lang.String) data));
        return true;
    }

    /**
     * Remove a vertex from the graph.
     * Also removes all edges adjacent to the vertex from the graph (all edges
     * that have the vertex as a source or a destination vertex).
     *
     * @param data the data item stored in the vertex to remove
     * @return true if a vertex with *data* has been removed, false if it was not in the graph
     * @throws NullPointerException if data is null
     */
    public boolean removeVertex(String data) {
        if(data == null) throw new NullPointerException("Cannot remove null vertex");
        IVertex removeVertex = vertices.get(data);
        if(removeVertex == null) return false; // vertex not found within graph
        // search all vertices for edges targeting removeVertex
        for(IVertex v : vertices.values()) {
            IEdge removeEdge = null;
            for(IEdge e : v.getEdges()) {
                if (e.getTarget() == removeVertex)
                    removeEdge = e;
            }
            // and remove any such edges that are found
            if(removeEdge != null) v.getEdges().remove(removeEdge);
        }
        // finally remove the vertex and all edges contained within it
        return vertices.remove(data) != null;
    }

    /**
     * Insert a new directed edge with a positive edge weight into the graph.
     *
     * @param source the data item contained in the source vertex for the edge
     * @param target the data item contained in the target vertex for the edge
     * @param weight the weight for the edge (has to be a positive integer)
     * @return true if the edge could be inserted or its weight updated, false
     *     if the edge with the same weight was already in the graph
     * @throws IllegalArgumentException if either source or target or both are not in the graph,
     *     or if its weight is < 0
     * @throws NullPointerException if either source or target or both are null
     */
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
        for(IEdge e : sourceVertex.getEdges()){
            if(e.getTarget() == targetVertex) {
                if(e.getWeight() == weight) return false; // edge already exists
                else e.setWeight(weight); // otherwise update weight of existing edge
                return true;
            }
        }
        // otherwise add new edge to sourceVertex
        sourceVertex.getEdges().add(new Edge(sourceVertex, targetVertex,weight));
        return true;
    }

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
        Edge removeEdge = null;
        for(IEdge e : sourceVertex.getEdges()) {
            if ((e.getTarget() == targetVertex))
                removeEdge = (Edge) e;
        }
        if(removeEdge != null) { // remove edge that is successfully found
            sourceVertex.getEdges().remove(removeEdge);
            return true;
        }
        return false; // otherwise return false to indicate failure to find
    }

    /**
     * Check if the graph contains a vertex with data item *data*.
     *
     * @param data the data item to check for
     * @return true if data item is stored in a vertex of the graph, false otherwise
     * @throws NullPointerException if *data* is null
     */
    public boolean containsVertex(String data) {
        if(data == null) throw new NullPointerException("Cannot contain null data vertex");
        return vertices.containsKey(data);
    }

    /**
     * Check if edge is in the graph.
     *
     * @param source the data item contained in the source vertex for the edge
     * @param target the data item contained in the target vertex for the edge
     * @return true if the edge is in the graph, false if it is not in the graph
     * @throws NullPointerException if either source or target or both are null
     */
    public boolean containsEdge(String source, String target) {
        if(source == null || target == null) throw new NullPointerException("Cannot contain edge adjacent to null data");
        IVertex sourceVertex = vertices.get(source);
        IVertex targetVertex = vertices.get(target);
        if(sourceVertex == null) return false;
        for(IEdge e : sourceVertex.getEdges())
            if((e.getTarget() == targetVertex))
                return true;
        return false;
    }

    /**
     * Return the weight of an edge.
     *
     * @param source the data item contained in the source vertex for the edge
     * @param target the data item contained in the target vertex for the edge
     * @return the weight of the edge (0 or positive integer)
     * @throws IllegalArgumentException if either sourceVertex or targetVertex or both are not in the graph
     * @throws NullPointerException if either sourceVertex or targetVertex or both are null
     * @throws NoSuchElementException if edge is not in the graph
     */
    public int getWeight(String source, String target) {
        if(source == null || target == null) throw new NullPointerException("Cannot contain weighted edge adjacent to null data");
        IVertex sourceVertex = vertices.get(source);
        IVertex targetVertex = vertices.get(target);
        if(sourceVertex == null || targetVertex == null) throw new IllegalArgumentException("Cannot retrieve weight of edge between vertices that do not exist");
        for(IEdge e : sourceVertex.getEdges())
            if(((Edge)e).getTarget() == targetVertex)
                return ((Edge) e).getWeight();
        throw new NoSuchElementException("No directed edge found between these vertices");
    }

    /**
     * Return the number of edges in the graph.
     *
     * @return the number of edges in the graph
     */
    public int getEdgeCount() {
        int edgeCount = 0;
        for(IVertex v : vertices.values())
            edgeCount += v.getEdges().size();
        return edgeCount;
    }

    /**
     * Return the number of vertices in the graph
     *
     * @return the number of vertices in the graph
     */
    public int getVertexCount() {
        return vertices.size();
    }

    /**
     * Check if the graph is empty (does not contain any vertices or edges).
     *
     * @return true if the graph does not contain any vertices or edges, false otherwise
     */
    public boolean isEmpty() {
        return vertices.size() == 0;
    }






    /**
     * Returns the shortest path between start and end.
     * Uses Dijkstra's shortest path algorithm to find the shortest path.
     *
     * @param start the data item in the starting vertex for the path
     * @param end the data item in the destination vertex for the path
     * @return list of data item in vertices in order on the shortest path between vertex
     * with data item start and vertex with data item end, including both start and end
     * @throws NoSuchElementException when no path from start to end can be found
     *     including when no vertex containing start or end can be found
     */
    public List<String> shortestPath(String start, String end) {
        return (List<String>) dijkstrasShortestPath(start,end).getDataSequence();
    }

    /**
     * Returns the cost of the path (sum over edge weights) between start and end.
     * Uses Dijkstra's shortest path algorithm to find the shortest path.
     *
     * @param start the data item in the starting vertex for the path
     * @param end the data item in the end vertex for the path
     * @return the cost of the shortest path between vertex with data item start
     * and vertex with data item end, including all edges between start and end
     * @throws NoSuchElementException when no path from start to end can be found
     *     including when no vertex containing start or end can be found
     */
    public int getPathCost(String start, String end) {
        return dijkstrasShortestPath(start, end).distance;
    }

}
