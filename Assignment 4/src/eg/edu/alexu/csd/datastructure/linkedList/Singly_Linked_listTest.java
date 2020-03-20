package eg.edu.alexu.csd.datastructure.linkedList;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Khalid Eltawagny
 */
public class Singly_Linked_listTest {
  Singly_Linked_list test = new Singly_Linked_list();
  /** The sub.*/
  ILinkedList sub;
  /** The x1.*/
  final int x1 = 1;
  /** The x2.*/
  final int x2 = 2;
  /** The x3.*/
  final int x3 = 3;
  /** The x9.*/
  final int x9 = 9;
  /** The x0.*/
  final int x0 = 0;
  /** The x20.*/
  final int x20 = 20;
  /** The x5.*/
  final int x5 = 5;
  /** The x60.*/
  final int x60 = 60;
  /** The x4.*/
  final int x4 = 4;
  /** The xn1.*/
  final int xn1 = -1;
  /** The x40.*/
  final int x40 = 40;
  /** The x6.*/
  final int x6 = 6;
  /** The x10.*/
  final int x10 = 10;

    /**
     * Test of add method, of class Singly_Linked_list.
     */
    @Test
    public void add() {
    test.add(x1); // 1
    test.add(x0, x5); // 5 1
    test.add(x6); // 5 1 6
    test.add(x3, x6); // 5 1 6 6
    assertEquals(test.get(3), x6);    
    }
  /**
   * Empty.
   */
  @Test
  public void empty() {
    test.add(x1); // 1
    test.add(x0, x5); // 5 1
    test.add(x6); // 5 1 6
    test.add(x3, x6); // 5 1 6 6
    test.clear();
    assertTrue(test.isEmpty());
  }
    /**
   * Adding out of list.
   */
  @Test(expected = RuntimeException.class)
  public void addingOutOfList() {
    test.add(x1); // 1
    test.add(x0, x5); // 5 1
    test.add(x6); // 5 1 6
    test.add(x3, x6); // 5 1 6 6
    test.add(x9, x6); // 5 1 6 6
  }
     /**
   * Gets the.
   */
  @Test
  public void get() {
    test.add(x1); // 1
    test.add(x0, x5); // 5 1
    test.add(x6); // 5 1 6
    test.add(x3, x6); // 5 1 6 6
    Integer[] ar = {x5, x1, x6, x6};
    Integer[] toget = new Integer[x4];
    for (int i = 0; i < test.size(); i++) {
      toget[i] = (Integer) test.get(i);
    }
    assertArrayEquals(toget, ar);
  } 
  
  /**
   * Contain.
   */
  @Test
  public void contain() {
    test.add(x1); // 1
    test.add(x0, x5); // 5 1
    test.add(x5); // 5 1 5
    test.add(x3, x6); // 5 1 5 6
    assertTrue(test.contains(x6));
  }
    /**
   * Not contain.
   */
  @Test
  public void notContain() {
    test.add(x1); // 1
    test.add(x0, x5); // 5 1
    test.add(x6); // 5 1 6
    test.add(x3, x6); // 5 1 6 6
    test.add(x1, x20); // 5 20 1 6 6
    assertFalse(test.contains(x40));
  }
  
  /**
   * Size.
   */
  @Test
  public void size() {
    test.add(x1); // 1
    test.add(x0, x5); // 5 1
    test.add(x6); // 5 1 6
    test.add(x3, x6); // 5 1 6 6
    test.add(x1, x20); // 5 20 1 6 6
    int sizeTest = test.size();
    test.remove(0); // 20 1 6 6
    assertEquals(test.size(), sizeTest - 1);
  }
  
  /**
   * After remove.
   */
  @Test
  public void afterRemove() {
    test.add(x1); // 1
    test.add(x0, x5); // 5 1
    test.add(x6); // 5 1 6
    test.add(x3, x6); // 5 1 6 6
    test.add(x1, x20); // 5 20 1 6 6
    test.remove(x3);
    Integer[] ar = {x5, x20, x1, x6};
    Integer[] toget = new Integer[x4];
    for (int i = 0; i < test.size(); i++) {
      toget[i] = (Integer) test.get(i);
    }
    assertArrayEquals(toget, ar);
  }
    /**
   * Removes the out of range.
   */
  @Test(expected = RuntimeException.class)
  public void removeOutOfRange() {
    test.add(x1); // 1
    test.add(x0, x5); // 5 1
    test.add(x6); // 5 1 6
    test.add(x3, x6); // 5 1 6 6
    test.add(x1, x20); // 5 20 1 6 6
    test.remove(xn1);
  }
  
  /**
   * Sets the.
   */
  @Test
  public void set() {
    test.add(x1); // 1
    test.add(x0, x5); // 5 1
    test.add(x6); // 5 1 6
    test.add(x3, x6); // 5 1 6 6
    test.add(x1, x20); // 5 20 1 6 6
    test.set(x2, x60);
    assertEquals(test.get(x2), x60);
  }
    /**
   * Sub list.
   */
  @Test
  public void subList() {
    test.add(x1); // 1
    test.add(x0, x5); // 5 1
    test.add(x6); // 5 1 6
    test.add(x3, x6); // 5 1 6 6
    sub = test.sublist(x1, x2);
    Integer[] taken = {x1, x6};
    Integer[] inSubList = new Integer[2];
    for (int i = 0; i < sub.size(); i++) {
      inSubList[i] = (Integer) sub.get(i);
    }
    assertArrayEquals(inSubList, taken);
  }
    /**
   * Sub list size.
   */
  @Test
  public void subListSize() {
    test.add(x1); // 1
    test.add(x0, x5); // 5 1
    test.add(x6); // 5 1 6
    test.add(x3, x6); // 5 1 6 6
    sub = test.sublist(x1, x2);
    assertEquals(sub.size(), x2);
  }
    /**
   * Adding null.
   */
  @Test(expected = RuntimeException.class)
  public void addingNull() {
    test.add(x1); // 1
    test.add(x0, x5); // 5 1
    test.add(x6); // 5 1 6
    test.add(x3, x6); // 5 1 6 6
    test.add(null);
    assertTrue(test.contains(null));
  }
}
