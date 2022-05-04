//// --== CS400 Project Three File Header ==--
//// Name: Nate Colburn
//// Email: ncolburn2@wisc.edu
//// Team: BN
//// TA: Sujitha Perumal
//// Lecturer: Gary Dahl
//// Notes to Grader: My class is pretty hard to test since both my methods are void and I am the
//// frontend, but I tested what I could think of
//
//
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
//
///**
// * This class uses JUnit tests to test the functionality of the FrontendMadisonMap class
// *
// * @author Nate Colburn
// *
// */
//class FrontendDeveloperTests extends FDFrontendMadisonMap {
//  FrontendMadisonMap testMap = new FrontendMadisonMap();
//
//  /**
//   * Tests to see if the DisplayShortestPath method throws any exceptions with a variety of inputs
//   */
//  @Test
//  public void test1() {
//    assertDoesNotThrow(() -> testMap.DisplayShortestPath("start", "end"));
//    assertDoesNotThrow(() -> testMap.DisplayShortestPath("randomnonsense---asdsdjadshdsajdsa",
//        "randomnonsense---asdsdjadshdsajdsa"));
//    assertDoesNotThrow(() -> testMap.DisplayShortestPath("", ""));
//    assertDoesNotThrow(() -> testMap.DisplayShortestPath("1", "1"));
//    assertDoesNotThrow(() -> testMap.DisplayShortestPath("112312321123", "123123123321"));
//  }
//
//  /**
//   * Tests to see if the DisplayShortestPath method throws any exceptions with a variety of inputs
//   */
//  @Test
//  public void test2() {
//    assertDoesNotThrow(() -> testMap.DisplayMinimumTree(new String[19]));
//    assertDoesNotThrow(() -> testMap.DisplayMinimumTree(new String[] {"1", "2", "3", "4", "5"}));
//    assertDoesNotThrow(() -> testMap.DisplayMinimumTree(new String[] {"", "", "", "", ""}));
//    assertDoesNotThrow(() -> testMap.DisplayMinimumTree(new String[] {"one"}));
//    assertDoesNotThrow(() -> testMap.DisplayMinimumTree(new String[] {"fsdfsdfsd", "gfsdgfds"}));
//  }
//
//  /**
//   * Tests to see if the DisplayMinimumTree method throws any exceptions when given a null value
//   */
//  @Test
//  public void test3() {
//    assertThrows(Exception.class, () -> testMap.DisplayMinimumTree(null));
//  }
//
//  /**
//   * Tests to see if the DisplayShortestPath method throws any exceptions when given a null value
//   */
//  @Test
//  public void test4() {
//    assertThrows(Exception.class, () -> testMap.DisplayShortestPath(null, null));
//  }
//
//  /**
//   * Tests to see if the DisplayShortestPath method and the DisplayMinimumTree method throw any
//   * exceptions when given the same input
//   */
//  @Test
//  public void test5() {
//    assertDoesNotThrow(() -> testMap.DisplayMinimumTree(new String[] {"1", "2"}));
//    assertDoesNotThrow(() -> testMap.DisplayShortestPath("1", "2"));
//    assertDoesNotThrow(() -> testMap.DisplayMinimumTree(new String[] {"start", "end"}));
//    assertDoesNotThrow(() -> testMap.DisplayShortestPath("start", "end"));
//
//  }
//
//
//}
//
