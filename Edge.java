import java.util.LinkedList;
import java.util.List;

/**
 * Edge objects are stored within their source vertex, and group together
 * their target destination vertex, along with an integer weight.
 */
public class Edge implements Comparable<Edge>, IEdge{
    public Vertex target;
    public Vertex start;
    public int weight;

    public Edge(Vertex target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public Edge(Vertex start, Vertex target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    /**
     * Allows the natural ordering of paths to be increasing with path distance.
     * When path distance is equal, the string comparison of end vertex data is used to break ties.
     * @param other is the other path that is being compared to this one
     * @return -1 when this path has a smaller distance than the other,
     *         +1 when this path has a larger distance that the other,
     *         and the comparison of end vertex data in string form when these distances are tied
     */
    public int compareTo(Edge other) {
        int cmp = this.weight - other.weight;
        if(cmp != 0) return cmp; // use path distance as the natural ordering
        // when path distances are equal, break ties by comparing the string
        // representation of data in the end vertex of each path
        return this.target.data.toString().compareTo(other.target.data.toString());
    }

    @Override public boolean isVisited() {
        return false;
    }
    public IVertex getStart() {
        return start;
    }
    public IVertex getTarget() {
        return target;
    }
}
