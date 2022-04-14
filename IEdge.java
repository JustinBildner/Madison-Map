/**
 * Edge Interface which defines the necessary methods for the Edge object
 * 
 * @author Noah Jillson
 */
public interface IEdge {
	public IVertex[] getVertices(); // Gets the two vertices that this edge connects
	public int getWeight(); // Returns the weight of the edge which represents distance in feet
	public boolean isVisited(); // Returns true if the node has been visited; false otherwise
}

