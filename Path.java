import java.util.LinkedList;
import java.util.List;

/**
 * Path objects store a discovered path of vertices and the overall distance of cost
 * of the weighted directed edges along this path. Path objects can be copied and extended
 * to include new edges and vertices using the extend constructor. In comparison to a
 * predecessor table which is sometimes used to implement Dijkstra's algorithm, this
 * eliminates the need for tracing paths backwards from the destination vertex to the
 * starting vertex at the end of the algorithm.
 */
public class Path implements Comparable<Path>, IShortestPath {
    public IVertex start; // first vertex within path
    public int distance; // sumed weight of all edges in path
    public List<String> dataSequence; // ordered sequence of data from vertices in path
    public IVertex end; // last vertex within path
    public List<IVertex> visited;
    public List<IEdge> edges;

    /**
     * Creates a new path containing a single vertex.  Since this vertex is both
     * the start and end of the path, it's initial distance is zero.
     * @param start is the first vertex on this path
     */
    public Path(IVertex start) {
        this.start = start;
        this.distance = 0;
        this.dataSequence = new LinkedList<>();
        this.dataSequence.add(start.getName());
        this.end = start;
    }

    /**
     * This extension constructor makes a copy of the path passed into it as an argument
     * without affecting the original path object (copyPath). The path is then extended
     * by the Edge object extendBy.
     * @param copyPath is the path that is being copied
     * @param extendBy is the edge the copied path is extended by
     */
    public Path(Path copyPath, Edge extendBy) {
        this.start = copyPath.start;
        this.distance = copyPath.distance;
        this.distance+=extendBy.getWeight();
        this.dataSequence = new LinkedList<>();
        for(int i =0; i <copyPath.dataSequence.size(); i++)
        {
            this.dataSequence.add(copyPath.dataSequence.get(i));
        }
        dataSequence.add(extendBy.getTarget().getName());
        this.end = extendBy.getTarget();
    }

    /**
     * Allows the natural ordering of paths to be increasing with path distance.
     * When path distance is equal, the string comparison of end vertex data is used to break ties.
     * @param other is the other path that is being compared to this one
     * @return -1 when this path has a smaller distance than the other,
     *         +1 when this path has a larger distance that the other,
     *         and the comparison of end vertex data in string form when these distances are tied
     */
    public int compareTo(Path other) {
        int cmp = this.distance - other.distance;
        if(cmp != 0) return cmp; // use path distance as the natural ordering
        // when path distances are equal, break ties by comparing the string
        // representation of data in the end vertex of each path
        return this.end.getName().toString().compareTo(other.end.getName().toString());
    }

    @Override public List<IVertex> getVertices() {
        return null;
    }

    @Override public List<IEdge> getEdges() {
        return null;
    }
}
