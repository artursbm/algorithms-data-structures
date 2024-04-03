package problems.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TwoSumIISortedArrayTest {

    private final TwoSumIISortedArray problem = new TwoSumIISortedArray();

    @Test
    void testSlowSolution() {
        int[] numbers = {2,7,11,15};
        var sol = problem.slowTwoSum(numbers, 9);
        assertArrayEquals(new int[] {1,2}, sol);

        numbers = new int[] {2,3,4};
        sol = problem.slowTwoSum(numbers, 6);
        assertArrayEquals(new int[] {1,3}, sol);

        numbers = new int[] {-1,0};
        sol = problem.slowTwoSum(numbers, -1);
        assertArrayEquals(new int[] {1,2}, sol);

        numbers = new int[] {1,2,3,4};
        sol = problem.slowTwoSum(numbers, 6);
        assertArrayEquals(new int[] {2,4}, sol);



    }

    @Test
    void testFastSolution() {
        int[] numbers = {2,7,11,15};
        var sol = problem.twoSum(numbers, 9);
        assertArrayEquals(new int[] {1,2}, sol);

        numbers = new int[] {2,3,4};
        sol = problem.twoSum(numbers, 6);
        assertArrayEquals(new int[] {1,3}, sol);

        numbers = new int[] {-1,0};
        sol = problem.twoSum(numbers, -1);
        assertArrayEquals(new int[] {1,2}, sol);

        numbers = new int[] {1,2,3,4};
        sol = problem.twoSum(numbers, 6);
        assertArrayEquals(new int[] {2,4}, sol);



    }

}