package problems.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergeSortedArraysTest {

    private final MergeSortedArrays arrays = new MergeSortedArrays();

    @Test
    void testSuccess() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        arrays.merge(nums1, 3, nums2, 3);
        assertArrayEquals(new int[]{1,2,2,3,5,6}, nums1);
    }

}