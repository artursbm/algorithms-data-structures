package problems.arrays;

import java.util.Arrays;

/**
 * Arrays a and b are similar if swapping EXACTLY 2 elements make them equal
 */
public class AreSimilarArrays {

  public boolean solution(int[] a, int[] b) {

    if (a.length != b.length) {
      return false;
    }

    // iterate over arrays until we find one different element;
    // if end of arrays are reached, arrays are equal, thus return true;
    int i = 0;
    while (i < a.length && a[i] == b[i]) {
      i++;
    }
    if (i == a.length) {
      return true;
    }

    // we need to perform only one swapping
    int expectedValue = a[i];
    int currValue = b[i];
    for (int j = i + 1; j < b.length; j++) {
      if (b[j] == expectedValue && a[j] == currValue) {
        b[i] = expectedValue;
        b[j] = currValue;
        break;
      }
    }

    return Arrays.equals(a, b);
  }

}
