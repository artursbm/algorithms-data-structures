package problems;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public static void main(String[] args) {
//        int[] nums = new int[] {2,2,1};
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber2(nums));
    }

    public static int singleNumber(int[] nums) {
        final Set<Integer> numsSet = new HashSet<Integer>();
        int number = 0;
        for (int num : nums) {
            if (!numsSet.contains(num)) {
                numsSet.add(num);
            } else {
                numsSet.remove(num);
            }
        }
        return (int) numsSet.toArray()[0];
    }

    // fastest solution seen at LeetCode
    public static int singleNumber2(int[] nums) {
        int sol = 0;
        for (int num : nums) {
            sol = sol ^ num;
        }
        return sol;
    }


}
