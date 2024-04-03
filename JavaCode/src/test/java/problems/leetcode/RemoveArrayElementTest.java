package problems.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RemoveArrayElementTest {

    private final RemoveArrayElement problem = new RemoveArrayElement();

    @Test
    void testSolution() {
        int[] nums = {3, 2, 2, 3};
        assertEquals(2, problem.removeElement(nums, 3));

        nums = new int[] {0,1,2,2,3,0,4,2};
        assertEquals(5, problem.removeElement(nums, 2));

    }

    @Test
    void testEdgeCase() {
        int[] nums = {1};
        assertEquals(0, problem.removeElement(nums, 1));
    }



}