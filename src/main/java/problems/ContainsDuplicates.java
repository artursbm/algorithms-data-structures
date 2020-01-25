package problems;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> setOfNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (setOfNums.contains(nums[i])) {
                return true;
            } else {
                setOfNums.add(nums[i]);
            }
        }
        return false;
    }
}
