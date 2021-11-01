package problems;

/**
 * Given a sorted array nums, remove the duplicates in-place
 * such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this
 * by modifying the input array in-place with O(1) extra memory.
 *
 * @author artursbm
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int len = 1;
        int j = 1;
        for (int i = 0; i < nums.length - 1; ) {
            if (j < nums.length) {
                if (nums[i] == nums[j]) {
                    j++;
                } else {
                    len++;
                    nums[++i] = nums[j];
                    j++;

                }
            } else break;
        }
        return len;

    }

}
