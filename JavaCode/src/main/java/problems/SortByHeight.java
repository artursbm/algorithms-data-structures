package problems;

import java.util.Arrays;

public class SortByHeight {

  public int[] solution(int[] a) {

    // a = [-1, 150, 190, 170, -1, -1, 160, 180]

    int[] notTrees = Arrays.stream(a).filter(n -> n != -1).sorted().toArray();

    int jNt = 0;

    for (int i = 0; i < a.length; i++) {
      if (a[i] != -1) {
        a[i] = notTrees[jNt];
        jNt++;
      }
    }

    return a;
  }

}
