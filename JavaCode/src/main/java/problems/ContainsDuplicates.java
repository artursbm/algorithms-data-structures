package problems;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> setOfNums = new HashSet<>();
    for (final int num : nums) {
      if (setOfNums.contains(num)) {
        return true;
      } else {
        setOfNums.add(num);
      }
    }
    return false;
  }
}
