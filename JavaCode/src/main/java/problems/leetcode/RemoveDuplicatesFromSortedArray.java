package problems.leetcode;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int k=1;
        int currElem = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != currElem) {
                currElem = nums[i];
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}
