import java.util.List;

/**
 * MapLoader Interface which defines the necessary methods for the MapLoader object
 * 
 * @author Noah Jillson
 */
public interface IMapLoader {
	public List<IVertex> loadMap(); // Loads all the hot spots in the .tsv file into a list of 
					// IVertex objects 
}

