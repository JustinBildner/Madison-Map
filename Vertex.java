import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Vertex objects group a data field with an adjacent list of weighted
 * directed edges that lead away from them.
 */
public class Vertex<T> implements IVertex{
    public T data; // vertex label
    public LinkedList<Edge> edgesLeaving;

    public Vertex(T data) {
        this.data = (T) data;
        this.edgesLeaving = new LinkedList<>();
    }

    @Override public String getName() {
        return (String) data;
    }

    @Override public int[] getCoordinates() {
        return new int[0];
    }

    @Override public Hashtable<String, IEdge> getEdges() {
        return null;
    }
}
