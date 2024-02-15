package problems.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayMaxConsecutiveSum2Test {

  private final ArrayMaxConsecutiveSum2 maxConsecutiveSum2 = new ArrayMaxConsecutiveSum2();

  @Test
  void testSum1() {
    int[] arr = new int[] {-2,2,5,-11,6};
    var expected = 7;

    assertEquals(expected, maxConsecutiveSum2.fastSolution(arr));
  }
}