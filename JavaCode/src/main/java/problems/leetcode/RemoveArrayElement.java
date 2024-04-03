package problems.leetcode;

public class RemoveArrayElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        // idea will be to place the correct values in the
        // beginning of the array
        int j = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;

    }
}
