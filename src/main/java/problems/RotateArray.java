package problems;

class RotateArray {
    public static void rotate(int[] nums, int k) {
        int s = 0;
        int e = nums.length;
        int numsPos;
        int[] newNums = new int[nums.length];
        for (int i = s; i < e; i++) {
            if (i + k >= e) {
                numsPos = (i + k) - e;
            } else {
                numsPos = (i + k);
            }
            newNums[numsPos] = nums[i];
        }
        System.arraycopy(newNums, s, nums, s, e - s);

    }

    public static void main(String[] args) {
        int[] nums = {-1};
        rotate(nums, 2);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
