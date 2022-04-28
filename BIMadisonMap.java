// --== CS400 Project Three File Header ==--
// Name: Benjamin Miller
// CSL Username: benm
// Email: bhmiller3@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: None

import java.util.Hashtable;


/** An instance of a class that implements the following interface can be used to compute the shortest
 * path between two verticy nodes and compute the minimum spanning tree of a group of veticies
 *
 * @param <T> Generic representing the type that is stored in the map
 */
public interface BIMadisonMap<T> extends GraphADT <T>{


    /** An instance of this method takes in a list of vertices or places we are visiting are returns a list of vertices that
     * make up a MinimumSpanningTree of the vertices visited and the edges traversed as well.
     *
     * @param start data for the start node
     * @return a
     */
    public BIShortestPath computeMinimumSpanningTree(T start);


    /** An instance of this method takes in a starting and ending vertex and returns a Shortest Path object
     *
     * @param start the starting vertex
     * @param end the ending vertex
     * @return a shortest path object which will contain an ordered list of vertices and edges visited
     */
    public BIShortestPath computeShortestPath(BIVertex start, BIVertex end);
    public Hashtable<T, BIVertex> getVertices();
}

