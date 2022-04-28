import java.util.List;

public class ShortestPath implements IShortestPath{
    public List<IVertex> vertices;
    public List<IEdge> edges;

    public ShortestPath(List<IVertex> vertices, List<IEdge> edges )
    {
        this.vertices=vertices;
        this.edges = edges;
    }

    @Override public List<IVertex> getVertices() {
        return null;
    }

    @Override public List<IEdge> getEdges() {
        return null;
    }
}
