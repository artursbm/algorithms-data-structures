package problems.leetcode;

import java.util.Arrays;

public class CountSubarraysWithMaxElemKtimes {
    public long countSubarrays(int[] nums, int k) {
        // assuming nums[] will never be empty
        int maxElem = Arrays.stream(nums).max().getAsInt();
        int maxElemOccurs = (int) Arrays.stream(nums).filter(n -> n == maxElem).count();

        // first edge case: max elem occurs less than k times in array
        if (maxElemOccurs < k) {
            return 0;
        }

        int l = 0, maxOccurrs = 0, subArraysCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxElem) {
                maxOccurrs++;
            }
            while (maxOccurrs >= k) {
                if (nums[l] == maxElem) {
                    maxOccurrs--;
                }
                l++;
            }
            subArraysCount += l;
        }
        return subArraysCount;

    }
}
