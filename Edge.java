// --== CS400 Project Three File Header ==--
// Name: Benjamin Miller
// CSL Username: benm
// Email: bhmiller3@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: None

/**
 * Working implementation of the BIEdge interface which provides the necessary construction 
 * for the graphical edges utilized within the IMadisonMap class.
 * @author Benjamin Miller
 */
public class Edge implements IEdge {
    private int weight; // corresponds to the distance between vertexA and vertexB
    private IVertex start; // contains the vertex that this edge starts from
    private IVertex target; // contains the vertex that this edge connects to
    private boolean visited; // Changed to true if included in MST formed by Engineer

    /**
     * Constructor which both initializes the "weight" field to its corresponding parameter and
     * adds two vertices, a source (A) and target (B), as indices 0 and 1, respectively, of the
     * internal BIVertex[] array.
     * @param A denotes the source IVertex object from which the Edge originates
     * @param B denotes the target IVertex object to which the Edge connects
     * @param weight denotes the weight of the Edge
     */
    public Edge(IVertex A, IVertex B, int weight) {
        this.start = A;
        this.target = B;
        this.weight = weight;
        this.visited = false;
    }

    /**
     * Accessor method for the Edge "start" field.
     * @return an IVertex denoting the start vertex connected by the Edge object
     */
    public IVertex getStart() {
        return start;
    }

    /**
     * Accessor method for the Edge "target" field.
     * @return an IVertex denoting the target vertex connected by the Edge object
     */
    public IVertex getTarget() {
        return start;
    }

    /**
     * Modifier method which enables the user to edit the weight of the Edge object
     * @param val denotes the desired edge weight
     */
    public void setWeight(int val) {
        weight = val;
    }

    /**
     * Accessor method for the Edge "weight" field.
     * @return the int weight of the Edge object
     */
    @Override
    public int getWeight() {
        return weight;
    }

    /**
     * Modifier method which enables the user to toggle the "visited" state of the Edge object
     */
    @Override
    public void setVisited(boolean status) {
        visited = status;
    }

    /**
     * Accessor method for the Edge "visited" field.
     * @return true if the Edge proves is visited when constructing a shortest path, false otherwise
     */
    @Override
    public boolean isVisited() {
        return visited;
    }



    /**
     * Allows the natural ordering of paths to be increasing with path distance.
     * When path distance is equal, the string comparison of end vertex data is used to break ties.
     * @param other is the other path that is being compared to this one
     * @return -1 when this path has a smaller distance than the other,
     *         +1 when this path has a larger distance that the other,
     *         and the comparison of end vertex data in string form when these distances are tied
     */
    public int compareTo(IEdge other) {
        int cmp = this.weight - other.getWeight();
        if(cmp != 0) return cmp; // use path distance as the natural ordering
        // when path distances are equal, break ties by comparing the string
        // representation of data in the end vertex of each path
        return this.getTarget().getName().compareTo(other.getTarget().getName());
    }
}
