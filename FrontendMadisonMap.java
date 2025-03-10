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
    // pathNames += start + " --> " + shortestPath.getEdges().get(0).getName() + " --> " + end;
    for (int i = 0; i < shortestPath.getEdges().size(); i++) {
      pathNames += shortestPath.getVertices().get(i).getName();
      pathNames += " --> ";
    }
    pathNames += end;
    // pathNames = pathNames.substring(0, pathNames.length()); // Trim the last " to " off the end
    System.out.println("The shortest path from " + start + " to " + end + " is: " + pathNames);
    System.out.println("The walking distance is: " + walkingDistance + " feet");
  }

  /**
   * This method displays the minimum path between multiple hotspots
   * 
   * @param vertices An array of strings, the names of the hotspots on the map
   */
  @Override
  public void DisplayMinimumTree(String vertices) {
    MadisonMapBackend map = new MadisonMapBackend(new MapLoader());
    IShortestPath shortestPath = map.getMinimumSpanningTree(vertices);
    String pathNames = "";
    System.out.println(shortestPath.getEdges().size());
    for (int i = 0; i < shortestPath.getEdges().size(); i++) {
      pathNames += shortestPath.getVertices().get(i).getName() + " --> ";
      // pathNames += shortestPath.getEdges().get(i).getName() + " --> ";
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
    String choice = "";
    System.out.println("\nWelcome to Madison Map!");
    while (!choice.equals("3")) {
      choice = "";
      String start = "";
      String end = "";
      FrontendMadisonMap map = new FrontendMadisonMap();
      System.out.println("-----------------------");
      System.out.println("Please choose an option:");
      System.out.println("(1) Display the shortest path between two hotspots");
      System.out.println("(2) Display a minimum spanning tree of all the hotspots");
      System.out.println("(3) Quit");
      Scanner in = new Scanner(System.in);
      choice = in.nextLine();
      if(choice.equals("3"))
        break;
      // Display shortest Path
      if (choice.equals("1")) {
        System.out.println("Our hotspots include: \nMemorial Union\n" + "Bascom Hill\n"
            + "Chadbourne Hall\n" + "Nicholas Recreation Center\n" + "Kohl Center\n"
            + "Lowell Center\n" + "Langdon & Lake\n" + "University Book Store\n"
            + "State Street Brats\n" + "Le C's\n" + "Danny's Pub\n" + "Parthenon Gyros\n"
            + "Ian's Pizza\n" + "Wisconsin State Capitol\n" + "Tornado Steak House\n"
            + "Madison Concourse Hotel\n" + "RED\n" + "Basset Street Brunch\n"
            + "Witte Residence Hall\n" + "Washington & Broom\n" + "Washington & Basset\n"
            + "Lake & University");
        System.out.println("\nEnter start location:");
        start = in.nextLine();
        System.out.println("\nEnter destination:");
        end = in.nextLine();
        map.DisplayShortestPath(start, end); // Calls the method with the specified start and end

        // Display MST
      } else if (choice.equals("2")) {
        String startingSpot = new String();
        System.out.println("Our hotspots include: \nMemorial Union\n" + "Bascom Hill\n"
            + "Chadbourne Hall\n" + "Nicholas Recreation Center\n" + "Kohl Center\n"
            + "Lowell Center\n" + "Langdon & Lake\n" + "University Book Store\n"
            + "State Street Brats\n" + "Le C's\n" + "Danny's Pub\n" + "Parthenon Gyros\n"
            + "Ian's Pizza\n" + "Wisconsin State Capitol\n" + "Tornado Steak House\n"
            + "Madison Concourse Hotel\n" + "RED\n" + "Basset Street Brunch\n"
            + "Witte Residence Hall\n" + "Washington & Broom\n" + "Washington & Basset\n"
            + "Lake & University");
        System.out.println("\nEnter start location:");
        startingSpot = in.nextLine();
        map.DisplayMinimumTree(startingSpot); // Calls the method with the specified hotspots
      } else {
        System.out.println("Invalid Input, please try again");
      }
    }
    System.out.println("Thanks for using Madison Map!");
  }
}



