package comp2402a3;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
* To test your implementations, run the main method of either class (FastDefaultList, FasterTable). These call the appropriate tester functions.
*
* Note: you need to implement the actual correctness and efficiency testing in the testPart1() and testPart2() methods below.*/

public class Tester {

  /** Handy for testing correctness since we know A2Table works*/
  public static <T> boolean tableEquals(Table<T> t1, Table<T> t2) {
    if (t1.rows() != t2.rows()) return false;
    if (t1.cols() != t2.cols()) return false;
    for (int i = 0; i < t1.rows(); i++) {
      for (int j = 0; j < t2.cols(); j++) {
        T x1 = t1.get(i, j);
        T x2 = t2.get(i, j);
        if (x1 != null && x2 == null) return false;
        if (x1 == null && x2 != null) return false;
        if (x1 != null && !x1.equals(x2)) return false;
      }
    }
    return true;
  }


  public static boolean testPart1(Table<Integer> t) {
    // put your testing code here
    return true;
  }

  /**Set up and time a run of testPart1() method*/
  public static void testTable(Table<Integer> tab) {
    long start = System.nanoTime();
    boolean result = Tester.testPart1(tab);
    long stop = System.nanoTime();
    double elapsed = (stop-start)/1e9;
    System.out.println("testPart1 returns " + result + " in " + elapsed + "s"
                       + " when testing a " + tab.getClass().getName());
  }


  public static boolean testPart2(List<Integer> ell) {
    // put your testing code here
    return true;
  }

  /**Set up and time a run of the testPart2() method*/
  public static void testDefaultList(List<Integer> ell) {
    long start = System.nanoTime();
    boolean result = Tester.testPart2(ell);
    long stop = System.nanoTime();
    double elapsed = (stop-start)/1e9;
    System.out.println("testPart1 returns " + result + " in " + elapsed + "s"
                       + " when testing a " + ell.getClass().getName());
  }

}
