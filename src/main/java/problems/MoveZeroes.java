package problems;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        // [4,2,4,0,0,3,0,5,1,0]
        int j = 1;
        for (int i = 0; i < nums.length - 1 && j < nums.length; ) {
            if (nums[i] == 0 && nums[j] != 0) {
                int n = nums[i];
                nums[i] = nums[j];
                nums[j] = n;
                i++;
                j++;
            } else if(nums[i] != 0 && nums[j] == 0){
                i++;
            } else {
                j++;
            }
        }
    }

}
