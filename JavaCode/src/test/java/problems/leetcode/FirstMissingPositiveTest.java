package problems.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FirstMissingPositiveTest {

    private final FirstMissingPositive firstMissingPositive = new FirstMissingPositive();

    @Test
    void testSuccessNonLinear() {
        int[] arr = {1, 2, 0};
        assertEquals(3, firstMissingPositive.firstMissingPositiveNonLinear(arr));

        arr = new int[] {3, 4, -1, 1};
        assertEquals(2, firstMissingPositive.firstMissingPositiveNonLinear(arr));

        arr = new int[] {7, 8, 9, 11, 12};
        assertEquals(1, firstMissingPositive.firstMissingPositiveNonLinear(arr));

        arr = new int[] {2,1};
        assertEquals(3, firstMissingPositive.firstMissingPositiveNonLinear(arr));
    }

    @Test
    void testSuccessSolLinear() {
        int[] arr = {1, 2, 0};
        assertEquals(3, firstMissingPositive.sol(arr));

        arr = new int[] {3, 4, -1, 1};
        assertEquals(2, firstMissingPositive.sol(arr));

        arr = new int[] {7, 8, 9, 11, 12};
        assertEquals(1, firstMissingPositive.sol(arr));

        arr = new int[] {2,1};
        assertEquals(3, firstMissingPositive.sol(arr));
    }

}