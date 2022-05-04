// --== CS400 Project Three File Header ==--
// Name: Nate Colburn
// Email: ncolburn2@wisc.edu
// Team: BN
// TA: Sujitha Perumal
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.Scanner;

/**
 * This class defines a program that finds the shortest path between points, or "hotspots", in
 * Madison
 * 
 * @author Nate Colburn
 *
 */
public class FrontendMadisonMap implements IFrontendMadisonMap {

  /**
   * This method displays the shortest path from one point to another
   * 
   * @param start A string for the starting destination
   * @param end   A string for the ending destination
   */
  @Override
  public void DisplayShortestPath(String start, String end) {
    MadisonMapBackend map = new MadisonMapBackend(new MapLoader());
    IShortestPath shortestPath = map.getShortestPath(start, end);
    String pathNames = "";
    int walkingDistance = 0;
    for (int i = 0; i < shortestPath.getEdges().size(); i++) {
      walkingDistance += shortestPath.getEdges().get(i).getWeight(); // Calculate walking distance
    }
    //pathNames += start + " --> " + shortestPath.getEdges().get(0).getName() + " --> " + end;
    pathNames += start + " --> " + end;
    pathNames = pathNames.substring(0, pathNames.length()); // Trim the last " to " off the end
    System.out.println("The shortest path from " + start + " to " + end + " is: " + pathNames);
    System.out.println("The walking time is: " + walkingDistance + " minute");
  }

  /**
   * This method displays the minimum path between multiple hotspots
   * 
   * @param vertices An array of strings, the names of the hotspots on the map
   */
  @Override
  public void DisplayMinimumTree(String vertices) {
    MadisonMapBackend map = new MadisonMapBackend();
    IShortestPath shortestPath = map.getMinimumSpanningTree(vertices);
    String pathNames = "";
    System.out.println(shortestPath.getEdges().size());
    for (int i = 0; i < shortestPath.getEdges().size(); i++) {
      pathNames += shortestPath.getVertices().get(i).getName() + " --> ";
      //pathNames += shortestPath.getEdges().get(i).getName() + " --> ";
    }
    pathNames += shortestPath.getVertices().get(shortestPath.getEdges().size()).getName(); // Adds
                                                                                           // the
                                                                                           // final
    // destination node
    // on to the end
    System.out.println("The minimum spanning tree is: " + pathNames);
  }

  /**
   * Runs the program
   */
  public static void main(String[] args) {
    String start = "";
    String end = "";
    FrontendMadisonMap map = new FrontendMadisonMap();
    System.out.println("Welcome to Madison Map!");
    System.out.println("-----------------------");
    System.out.println("Please choose an option:");
    System.out.println("(1) Display the shortest path between two hotspots");
    System.out.println("(2) Display a minimum spanning tree of all the hotspots");
    Scanner in = new Scanner(System.in);
    String s1 = in.nextLine();

    // Display shortest Path
    if (s1.equals("1")) {
      System.out.println("Our hotspots include: \nKohl Center\n" + "Witte Residence Hall\n"
          + "Chadbourne Residence Hall\n" + "Nicholas Recreation Center\n" + "Capital\n"
          + "Bascom Hill\n" + "Le C’s\n" + "Bassett Street Brunch club\n" + "University BookStore\n"
          + "State Street Brats\n" + "Danny's Pub\n" + "Ian’s Pizza\n" + "Red\n" + "Target\n"
          + "Tornado Steak house\n" + "Parthenon Gyros\n" + "Lowell Center\n"
          + "Madison Concourse Hotel\n" + "Memorial Union Terrace");
      System.out.println("\nEnter start location:");
      start = in.nextLine();
      System.out.println("\nEnter destination:");
      end = in.nextLine();
      map.DisplayShortestPath(start, end); // Calls the method with the specified start and end

      // Display MST
    } else if (s1.equals("2")) {
      String startingSpot = new String();
      System.out.println("Our hotspots include: \nKohl Center\n" + "Witte Residence Hall\n"
          + "Chadbourne Residence Hall\n" + "Nicholas Recreation Center\n" + "Capital\n"
          + "Bascom Hill\n" + "Le C’s\n" + "Bassett Street Brunch club\n" + "University BookStore\n"
          + "State Street Brats\n" + "Danny's Pub\n" + "Ian’s Pizza\n" + "Red\n" + "Target\n"
          + "Tornado Steak house\n" + "Parthenon Gyros\n" + "Lowell Center\n"
          + "Madison Concourse Hotel\n" + "Memorial Union Terrace");
      System.out.println("\nEnter start location:");
      startingSpot = in.nextLine();
      System.out.println(
          "Enter a starting locations");
        startingSpot = in.nextLine();
      map.DisplayMinimumTree(startingSpot); // Calls the method with the specified hotspots
    } else {
      System.out.println("Invalid Input, please try again");
    }
  }
}



