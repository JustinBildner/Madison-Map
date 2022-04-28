// --== CS400 Project Three File Header ==--
// Name: Nate Colburn
// Email: ncolburn2@wisc.edu
// Team: BN
// TA: Sujitha Perumal
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

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
   * @param args An array of strings (points on the map) inputted from the terminal
   */
  void DisplayShortestPath(String start, String end);

  /**
   * Calls the back end minimumTree method and displays the shortest path between multiple nodes
   * 
   * @param args An array of strings (points on the map) inputted from the webpage
   */
  void DisplayMinimumTree(String[] vertices);
  
  /**
   * Main method that takes an array of strings from the terminal
   * 
   * @param args An array of strings (points on the map) inputted from the terminal
   */
}
