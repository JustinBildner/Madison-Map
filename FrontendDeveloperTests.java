// --== CS400 Project Three File Header ==--
// Name: Nate Colburn
// Email: ncolburn2@wisc.edu
// Team: BN
// TA: Sujitha Perumal
// Lecturer: Gary Dahl
// Notes to Grader: My class is pretty hard to test since both my methods are void and I am the
// frontend, but I tested what I could think of


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * This class uses JUnit tests to test the functionality of the FrontendMadisonMap class
 * 
 * @author Nate Colburn
 *
 */
class FrontendDeveloperTests extends FrontendMadisonMap {
  FrontendMadisonMap testMap = new FrontendMadisonMap();

  /**
   * Tests to see if the DisplayShortestPath method throws any exceptions with a variety of inputs
   */
  @Test
  public void test1() {
    assertDoesNotThrow(() -> testMap.DisplayShortestPath("RED", "Kohl Center"));
    assertDoesNotThrow(() -> testMap.DisplayShortestPath("Ian's Pizza",
        "Witte Residence Hall"));
    assertDoesNotThrow(() -> testMap.DisplayShortestPath("State Street Brats", "Memorial Union"));
    assertDoesNotThrow(() -> testMap.DisplayShortestPath("Lowell Center", "University Book Store"));
    assertDoesNotThrow(() -> testMap.DisplayShortestPath("Washington & Broom", "Washington & Basset"));
  }

  /**
   * Tests to see if the DisplayShortestPath method throws any exceptions with a variety of inputs
   */
  @Test
  public void test2() {
    assertThrows(Exception.class, () -> testMap.DisplayMinimumTree("1"));
    assertThrows(Exception.class, () -> testMap.DisplayMinimumTree(""));
    assertThrows(Exception.class, () -> testMap.DisplayMinimumTree("one"));
    assertThrows(Exception.class, () -> testMap.DisplayMinimumTree("fsdfsdfsd"));
  }

  /**
   * Tests to see if the DisplayMinimumTree method throws any exceptions when given a null value
   */
  @Test
  public void test3() {
    assertThrows(Exception.class, () -> testMap.DisplayMinimumTree(null));
  }

  /**
   * Tests to see if the DisplayShortestPath method throws any exceptions when given a null value
   */
  @Test
  public void test4() {
    assertThrows(Exception.class, () -> testMap.DisplayShortestPath(null, null));
  }

  /**
   * Tests to see if the DisplayShortestPath method and the DisplayMinimumTree method throw any
   * exceptions when given similar input
   */
  @Test
  public void test5() {
    assertDoesNotThrow(() -> testMap.DisplayMinimumTree("RED"));
    assertDoesNotThrow(() -> testMap.DisplayShortestPath("RED", "Basset Street Brunch"));
    assertDoesNotThrow(() -> testMap.DisplayMinimumTree("Witte Residence Hall"));
    assertDoesNotThrow(() -> testMap.DisplayShortestPath("Witte Residence Hall", "Kohl Center"));

  }


}

