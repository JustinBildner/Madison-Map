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
public class Edge implements Comparable<Edge>, IEdge {
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


    @Override public int compareTo(Edge other) {
        int cmp

    }
}
