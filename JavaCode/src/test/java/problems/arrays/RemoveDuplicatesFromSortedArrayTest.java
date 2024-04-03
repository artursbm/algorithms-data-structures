package problems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import problems.leetcode.RemoveDuplicatesFromSortedArray;

class RemoveDuplicatesFromSortedArrayTest {

    private final RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray =
      new RemoveDuplicatesFromSortedArray();

    @Test
    void testSuccessCase() {
        var nums = new int[] {1, 1, 2, 2, 3};
        var nums2 = new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3};

        assertEquals(3, removeDuplicatesFromSortedArray.removeDuplicates(nums));
        assertEquals(4, removeDuplicatesFromSortedArray.removeDuplicates(nums2));
    }

}