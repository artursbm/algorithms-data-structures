package problems.leetcode;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int currElem = nums[0];
        int countCurrElem = 1;
        int originalLen = nums.length;

        for (int i = 1; i < originalLen; i++) {
            if(nums[i] == currElem) {
                countCurrElem++;
                if(countCurrElem > 2) {
                    for(int j = i; j<nums.length-1; j++) {
                        nums[j] = nums[j+1];
                    }
                    originalLen--;
                    if(nums[i] != currElem) {
                        currElem = nums[i];
                        countCurrElem = 1;
                    } else {
                        i--;
                    }
                }
            } else {
                currElem = nums[i];
                countCurrElem = 1;
            }
        }
        return originalLen;
    }
}
