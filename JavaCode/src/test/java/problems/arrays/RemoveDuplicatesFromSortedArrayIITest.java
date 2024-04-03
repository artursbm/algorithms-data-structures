package problems.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import problems.leetcode.RemoveDuplicatesFromSortedArrayII;

class RemoveDuplicatesFromSortedArrayIITest {

    private final RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII =
      new RemoveDuplicatesFromSortedArrayII();

    @Test
    void testSuccessCase() {
        var nums = new int[] {1,1,2,2,3};
        var nums2 = new int[] {0,0,1,1,1,1,2,3,3};

        assertEquals(5, removeDuplicatesFromSortedArrayII.removeDuplicates(nums));
        assertEquals(7, removeDuplicatesFromSortedArrayII.removeDuplicates(nums2));
    }



}