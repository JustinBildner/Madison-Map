import java.util.Hashtable;

/**
 * Vertex Interface which defines the necessary methods for Vertex
 * 
 * @author Noah Jillson
 */
public interface IVertex {
	public String getName(); // Gets the name of a given vertex 
			   	 // (i.e. book store or University intersection)

	public int[] getCoordinates(); // Gets the xy-coordinates of any given node on the map with 
  				       // the bottom left corner being (0,0). The values are represent 
				       // distance on the map in feet from (0,0).

	public Hashtable<String, IEdge> getEdges(); // Gets the Hash Table containing all edges
					    	    // connected to this node. The key in this Hash
					    	    // Table is the name of the other node that is
						    // connected to this node by the edge stored as the
	    					    // value.
}

