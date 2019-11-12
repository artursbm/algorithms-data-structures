package binarysearch;

import lombok.Getter;
import lombok.Setter;

/**
 * @author artursbm
 *
 * Performs binary search in recursive way
 */

@Getter
@Setter
public class BinarySearch {

    public BinarySearch() {
    };

    public int search(int[] nums, int target) {
        // need to set 3 indices: l,r,m;
        int l = 0;
        int r = nums.length - 1;
        int m = (l + r) / 2;
        // if target == nums[m] -> return m; base case
        // if target between l and m -> r=m, m=(l+r)/2
        // else -> l=m, m=(l+r)/2
        int index = binarySearch(nums, l, m, r, target);
        return index;

    }

    public int binarySearch(int[] nums, int l, int m, int r, int target) {
        if (l >= r && target != nums[m]) return -1;
        if (target == nums[m]) {
            return m;
        } else if (target < nums[m]) {
            r = m - 1;
            m = (l + r) / 2;
            return binarySearch(nums, l, m, r, target);
        } else if (target > nums[m]) {
            l = m + 1;
            m = (l + r) / 2;
            return binarySearch(nums, l, m, r, target);
        }
        return -1;
    }
}
