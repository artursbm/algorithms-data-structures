package problems;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SumOfTwoTest {

  SumOfTwo sumOfTwo = new SumOfTwo();

  @Test
  void testCase1() {
    int[] a = new int[] {1, 4, 3, 6, 10, 1, 0, 1, 6, 5};
    int[] b = {9, 5, 6, 9, 0, 1, 2, 1, 6, 10};
    int v = 8;

    assertTrue(sumOfTwo.solution(a, b, v));
  }

}