// --== CS400 Project Three File Header ==--
// Name: Nate Colburn
// Email: ncolburn2@wisc.edu
// Team: BN
// TA: Sujitha Perumal
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.List;

public class FDVertex implements FDIVertex {
    private String locationName; // Name of the hotspot location
    private List<FDIEdge> connectingEdges; // List of all edges connected to the Vertex
    private int[] coordinates; // x and y-coordinates of the vertex (index 0 = x, index 1 = y)
    
    public FDVertex(String name, List<FDIEdge> connectingEdges, int x, int y) {
      locationName = name;
      this.connectingEdges = connectingEdges;
      coordinates = new int[] {x, y};
    }
    
    // Returns Location Name
    @Override
    public String getName() {
     return locationName;
    }
    
    
    // Returns the X and Y Coordinates as an Array
    @Override
    public int[] getCoordinates() {
      return coordinates;
    }
}

