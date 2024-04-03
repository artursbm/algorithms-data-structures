package problems.leetcode;

public class TwoSumIISortedArray {
    // simple solution O(N^2)
    public int[] slowTwoSum(int[] numbers, int target) {
        int i = 0, j = 1;
        int sum = numbers[i] + numbers[j];
        if(sum == target) return new int[] {++i, ++j};
        while (j <= numbers.length && sum != target) {
            if(j== numbers.length) {
                i++;
                j=i+1;
            }
            else {
                sum = numbers[i] + numbers[j];
                j++;
            }
        }
        return new int[] {++i, j};
    }

    public int[] twoSum(int[] numbers, int target) {
        int i=0, j=numbers.length-1;
        int sum=numbers[i]+numbers[j];
        while(sum != target) {
            sum = numbers[i]+numbers[j];
            if(sum < target) {
                i++;
            } else if(sum > target) {
                j--;
            }
        }
        return new int[] {++i, ++j};
    }
}
