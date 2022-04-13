// --== CS400 Project Three File Header ==--
// Name: Nathaniel Colburn
// CSL Username: colburn
// Email: ncolburn2@wisc.edu
// Lecture #: 002 @1:00pm
// Notes to Grader: <any optional extra notes to your grader>

/**
 * This interface provides the methods to make an interactive map of Madison to find the shortest
 * path between two points
 * 
 * @author Nate Colburn
 *
 */
public interface IFrontendMadisonMap {
  /**
   * Calls the back end shortestPath method and displays on the map the shortest path between two
   * points
   * 
   * @param args An array of strings (points on the map) inputted from the webpage
   */
  void DisplayShortestPath(String[] vertexes);

  /**
   * Calls the back end minimumTree method and displays the shortest path between multiple nodes
   * 
   * @param args An array of strings (points on the map) inputted from the webpage
   */
  void DisplayMinimumTree(String[] vertexes);
  
  /**
   * Main method that takes an array of strings from the website
   * 
   * @param args An array of strings (points on the map) inputted from the webpage
   */
  public static void main(String[] args);
}
