// --== CS400 Project Three File Header ==--
// Name: Benjamin Miller
// CSL Username: benm
// Email: bhmiller3@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: None

import java.util.Hashtable;

public interface BIMapLoader {
  /**
   * Loads all the hot spots in the .tsv file into a list of IVertex objects.
   * @return a Hashtable<String, IVertex> object denoting the desired vertices to include in the working 
   * implementation of the IMadisonMap object
   */
  public Hashtable<String, IVertex> loadMap();
}
