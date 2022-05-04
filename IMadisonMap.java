// --== CS400 File Header ==--
// Name: Justin Bildner
// CSL Username: bildner
// Email: bildner@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: 
import java.util.List;


/** An instance of a class that implements the following interface can be used to compute the shortest
 * path between two verticy nodes and compute the minimum spanning tree of a group of veticies
 *
 * @param <T> Generic representing the type that is stored in the map
 */
public interface IMadisonMap<T> extends GraphADT <T>{


    /** An instance of this method takes in a list of vertices or places we are visiting are returns a list of vertices that
     * make up a MinimumSpanningTree of the vertices visited and the edges traversed as well.
     *
     * @param start data for the start node
     * @return a
     */
    public IShortestPath computeMinimumSpanningTree(T start);
    public Hashtable<String, IVertex> getVertices();

}
