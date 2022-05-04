import java.util.Hashtable;

/**
 * MapLoader Interface which defines the necessary methods for the MapLoader object
 * 
 * @author Noah Jillson
 */
public interface IMapLoader {
/**
   * Loads all the hot spots in the .tsv file into a list of IVertex objects.
   * @return a Hashtable<String, IVertex> object denoting the desired vertices to include in the working 
   * implementation of the IMadisonMap object
   */
  public Hashtable<String, IVertex> loadMap();
}

