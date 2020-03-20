package eg.edu.alexu.csd.datastructure.linkedList;
/**
*
* @author Ahmed Elfax
* @author Khalid Eltawagny
*/
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The Class PolyTests.
 */
public class PolyTests {
  /** The poly. */
  PolynomialSolver poly = new PolynomialSolver();
  /** The x1. */
  final int x1 = 1;
  /** The x2. */
  final int x2 = 2;
  /** The x3. */
  final int x3 = 3;
  /** The x7. */
  final int x7 = 7;
  /** The x0. */
  final int x0 = 0;
  /** The x9. */
  final int x9 = 9;
  /** The x5. */
  final int x5 = 5;
  /** The x14. */
  final int x14 = 14;
  /** The x4. */
  final int x4 = 4;
  /** The xn1. */
  final int xn1 = -1;
  /** The xn7. */
  final int xn7 = -7;
  /** The xn10. */
  final int xn10 = -10;
  /** The x10. */
  final int x10 = 10;
  /** The xn3. */
  final int xn3 = -3;
  /** The array1. */
  int[][] array1 = new int[][] {{x2, x3}, {x7, x1}};
  /** The array2. */
  int[][] array2 = new int[][] {{x2, x1}, {x1, x0}};
  /** The sum. */
  int[][] sum = new int[][] {{x2, x3}, {x9, x1}, {x1, x0}};
  /** The sub. */
  int[][] sub = new int[][] {{x2, x3}, {x5, x1}, {xn1, x0}};
  /** The multiply. */
  int[][] multiply = new int[][] {{x4, x4}, {x2, x3}, {x14, x2},
    {x7, x1}};

  /**
   * Test.
   */
  @Test
  public void test() {

    int[][] ray1;
    int[][] ray2;
    int[][] ray3;
    poly.setPolynomial('A', array1);
    poly.setPolynomial('B', array2);
    ray1 = poly.add('A', 'B');
    ray2 = poly.subtract('A', 'B');
    ray3 = poly.multiply('A', 'B');
    assertArrayEquals(sum, ray1);
    assertArrayEquals(sub, ray2);
    assertArrayEquals(multiply, ray3);
  }

  /**
   * Test2.
   */
  @Test
  public void test2() {
    PolynomialSolver solver = new PolynomialSolver();
    int[][] array11 = new int[][] {{x2, x4}, {x3, x3}, {xn7, x2},
      {x3, x1}};
    int[][] array22 = new int[][] {{x2, x5}, {x3, x4}, {xn7, x3},
      {x3, x2}};
    int[][] array3 = new int[][] {{x0, x4}, {x0, x3}, {x0, x2},
      {x0, x1}};
    solver.setPolynomial('A', array11);
    solver.setPolynomial('B', array22);
    solver.setPolynomial('C', array3);
    final int[][] answer4 = new int[][] {{x2, x5}, {x1, x4},
      {xn10, x3}, {x10, x2}, {xn3, x1}};
    assertArrayEquals(array11, solver.subtract('A', 'C'));
    assertArrayEquals(array11, solver.add('A', 'C'));
    assertArrayEquals(answer4, solver.subtract('B', 'A'));
    String printed = solver.print('R');
    assertEquals("2x^5+x^4-10x^3+10x^2-3x", printed);
  }

  /**
   * Test3.
   */
  @Test(expected = RuntimeException.class)
  public void test3() {
    poly.clearPolynomial('A');
  }

  

  /**
   * Test4.
   */
  @Test(expected = RuntimeException.class)
  public void test4() {
    poly.add('A', 'B');
  }
  /**
   * Test5.
   */
  @Test
  public void test5() {
	  poly.setPolynomial('A', array1);
      float result;
      result=poly.evaluatePolynomial('A', 2);
      assertEquals(30, result, 0);
  }
}
