package problems.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CountSubarraysWithMaxElemKtimesTest {

    private final CountSubarraysWithMaxElemKtimes countSubArrs = new CountSubarraysWithMaxElemKtimes();

    @Test
    void testBuildRoots() {
        var arr = new int[] {1, 3, 2, 3, 3};
        var k = 2;

        assertEquals(6, countSubArrs.countSubarrays(arr, k));
    }

}