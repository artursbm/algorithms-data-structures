package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumOfTwo {

  boolean solution(int[] a, int[] b, int v) {
    if(a.length == 0 || b.length == 0) return false;

    // if I have sorted arrays, I only need to iterate until a[i] + b[i] < v
    // worst case, I need to go through all arrays to find the answer.
    Arrays.sort(a);
    Arrays.sort(b);

    int startA = 0;
    int startB = 0;
    if(v > 0) {
      while(a[startA] < 0 && b[startB] < 0) {
        startA++;
        startB++;
      }
      for(int i=startA; i<a.length; i++) {
        for(int j=startB; j<b.length; j++) {
          if(b[j] > v)
            j=b.length;
          else if(a[i]+b[j] == v)
            return true;

        }
      }
    }
    else {
      for(int i=startA; i<a.length; i++) {
        for(int j=startB; j<b.length; j++) {
          if(a[i]+b[j] == v) return true;
        }
      }

    }
    return false;
  }

  public boolean betterSolution(int[] a, int[] b, int v) {
    Set<Integer> solve = new HashSet<>();
    for(int elem : a) {
      solve.add(v-elem);
    }
    for(int elem : b) {
      if (!solve.add(elem)) {
        return true;
      }
    }

    return false;
  }




}
