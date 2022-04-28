import java.util.*;

public class MadisonMap<T> implements IMadisonMap<T> {

    @Override public ShortestPath computeMinimumSpanningTree(T start) {
        if(containsVertex(start) == false)
            throw new NoSuchElementException();

        //Priority Queue that tracks the paths visited so far
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        List<IVertex> visited = new ArrayList<>();
        List<IEdge> edgesTraversed = new ArrayList<>();

        Edge tE = new Edge(vertices.get(start), vertices.get(start), 0);

//        Path tP = new Path(vertices.get(start));
//        Path eTP;

        pq.add(tE);

        //While loop until the shortest path found between start and end is found
        while(!pq.isEmpty()){

            tE = pq.poll();

            //Go through every edge that is encounters checking to see if shortest path to vertices has been found yet
            for(int i = 0; i < tE.target.edgesLeaving.size(); i++){
                if(!visited.contains((tE.target.edgesLeaving.get(i)))){
                    pq.add((Edge) tE.target.edgesLeaving.get(i));
                    pq = checkReplace(pq, (Edge) tE.target.edgesLeaving.get(i));
                }
            }

            //After a vertex has been visited and all its connecting vertices discovered it's added to the list to not be looked at again
            visited.add(tE.target);
            edgesTraversed.add(tE);

        }

        return new ShortestPath(visited, edgesTraversed);
    }

    public PriorityQueue<Edge> checkReplace(PriorityQueue<Edge> pq, Edge newEdge){

        //iterate through nodes in priority queue and update the key for the vertex
        Iterator it = pq.iterator();

        while (it.hasNext()) {
            System.out.println("here");
            Edge edge = (Edge) it.next();
            if(newEdge.target == edge.target) {
                if (newEdge.compareTo(edge) < 0) {
                    pq.remove(edge);
                }
                else if(newEdge.compareTo(edge) > 0){
                    pq.remove(newEdge);
                    System.out.println(newEdge.target.data);
                }
            }

        }
        return pq;
    }

    /**
     * Returns the shortest path between start and end.
     * Uses Dijkstra's shortest path algorithm to find the shortest path.
     *
     * @param start the data item in the starting vertex for the path
     * @return list of data item in vertices in order on the shortest path between vertex
     * with data item start and vertex with data item end, including both start and end
     * @throws NoSuchElementException when no path from start to end can be found
     *     including when no vertex containing start or end can be found
     */
    public List<T> minTreeVert(T start) {
        List<IVertex> vertices = computeMinimumSpanningTree(start).vertices;
        List<T> data = new ArrayList<>();
        for(IVertex v: vertices)
        {
            data.add((T)v.getName());
        }
        return data;
    }

    public List<T> minTreeEdge(T start) {
        List<IEdge> edges = computeMinimumSpanningTree(start).edges;
        List<T> data = new ArrayList<>();
        for(IEdge e: edges)
        {
            data.add((T)(((Edge)e).getStart().getName() + ((Edge)e).getTarget().getName()));
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
    public Path dijkstrasShortestPath(T start, T end) {
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
        List<Vertex> visited = new ArrayList<Vertex>();

        Path eTP;

        //While loop until the shortest path found between start and end is found
        while(pq.isEmpty() == false){

            //End vertex has been found
            if(tP.end.data.equals(end)) {
                tP.visited = visited;
                return tP;
            }

            //Go through every edge that is encounters checking to see if shortest path to vertices has been found yet
            for(int i = 0; i < tP.end.edgesLeaving.size(); i++){
                if(!visited.contains(((Edge)tP.end.edgesLeaving.get(i)).target)){
                    pq.add(new Path(tP, (Edge) tP.end.edgesLeaving.get(i)));
                }
            }

            //After a vertex has been visited and all its connecting vertices discovered it's added to the list to not be looked at again
            visited.add(tP.end);

            //Change temp path to the shortest path from the priority queue
            eTP = tP;
            tP = pq.poll();
//            for(int i = 0; i < tP.end.edgesLeaving.size(); i++){
//                if(tP.end == ((Edge)eTP.end.edgesLeaving.get(i)).target){
//                    pq.add(new Path(tP, (Edge) tP.end.edgesLeaving.get(i)));
//                }
//            }

        }
        //When there is no path between the start and end nodes then NoSuchElementException will be thrown
        throw new NoSuchElementException();
    }

    @Override public IShortestPath computeShortestPath(IVertex start, IVertex end) {
        return null;
    }

    public Hashtable<T, Vertex> vertices; // holds graph verticies, key=data
    public MadisonMap() {
        vertices = new Hashtable<>();
    }

    public Hashtable<T, Vertex> getVertices()
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
    public boolean insertVertex(T data) {
        if(data == null)
            throw new NullPointerException("Cannot add null vertex");
        if(vertices.containsKey(data)) return false; // duplicate values are not allowed
        vertices.put(data, new Vertex(data));
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
    public boolean removeVertex(T data) {
        if(data == null) throw new NullPointerException("Cannot remove null vertex");
        Vertex removeVertex = vertices.get(data);
        if(removeVertex == null) return false; // vertex not found within graph
        // search all vertices for edges targeting removeVertex
        for(Vertex v : vertices.values()) {
            Edge removeEdge = null;
            for(Object e : v.edgesLeaving) {
                e = (Edge) e;
                if (((Edge) e).target == removeVertex)
                    removeEdge = (Edge) e;
            }
            // and remove any such edges that are found
            if(removeEdge != null) v.edgesLeaving.remove(removeEdge);
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
    public boolean insertEdge(T source, T target, int weight) {
        if(source == null || target == null)
            throw new NullPointerException("Cannot add edge with null source or target");
        Vertex sourceVertex = this.vertices.get(source);
        Vertex targetVertex = this.vertices.get(target);
        if(sourceVertex == null || targetVertex == null)
            throw new IllegalArgumentException("Cannot add edge with vertices that do not exist");
        if(weight < 0)
            throw new IllegalArgumentException("Cannot add edge with negative weight");
        // handle cases where edge already exists between these verticies
        for(Object e : sourceVertex.edgesLeaving){
            e = (Edge)e;
            if(((Edge) e).target == targetVertex) {
                if(((Edge) e).weight == weight) return false; // edge already exists
                else ((Edge) e).weight = weight; // otherwise update weight of existing edge
                return true;
            }
        }
        // otherwise add new edge to sourceVertex
        sourceVertex.edgesLeaving.add(new Edge(targetVertex,weight));
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
    public boolean removeEdge(T source, T target) {
        if(source == null || target == null) throw new NullPointerException("Cannot remove edge with null source or target");
        Vertex sourceVertex = this.vertices.get(source);
        Vertex targetVertex = this.vertices.get(target);
        if(sourceVertex == null || targetVertex == null) throw new IllegalArgumentException("Cannot remove edge with vertices that do not exist");
        // find edge to remove
        Edge removeEdge = null;
        for(Object e : sourceVertex.edgesLeaving) {
            if (((Edge)e).target == targetVertex)
                removeEdge = (Edge) e;
        }
        if(removeEdge != null) { // remove edge that is successfully found
            sourceVertex.edgesLeaving.remove(removeEdge);
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
    public boolean containsVertex(T data) {
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
    public boolean containsEdge(T source, T target) {
        if(source == null || target == null) throw new NullPointerException("Cannot contain edge adjacent to null data");
        Vertex sourceVertex = vertices.get(source);
        Vertex targetVertex = vertices.get(target);
        if(sourceVertex == null) return false;
        for(Object e : sourceVertex.edgesLeaving)
            if(((Edge)e).target == targetVertex)
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
    public int getWeight(T source, T target) {
        if(source == null || target == null) throw new NullPointerException("Cannot contain weighted edge adjacent to null data");
        Vertex sourceVertex = vertices.get(source);
        Vertex targetVertex = vertices.get(target);
        if(sourceVertex == null || targetVertex == null) throw new IllegalArgumentException("Cannot retrieve weight of edge between vertices that do not exist");
        for(Object e : sourceVertex.edgesLeaving)
            if(((Edge)e).target == targetVertex)
                return ((Edge) e).weight;
        throw new NoSuchElementException("No directed edge found between these vertices");
    }

    /**
     * Return the number of edges in the graph.
     *
     * @return the number of edges in the graph
     */
    public int getEdgeCount() {
        int edgeCount = 0;
        for(Vertex v : vertices.values())
            edgeCount += v.edgesLeaving.size();
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
    public List<T> shortestPath(T start, T end) {
        return dijkstrasShortestPath(start,end).dataSequence;
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
    public int getPathCost(T start, T end) {
        return dijkstrasShortestPath(start, end).distance;
    }

}
