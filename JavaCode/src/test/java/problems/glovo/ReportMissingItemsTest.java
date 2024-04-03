package problems.glovo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class ReportMissingItemsTest {

    private final ReportMissingItems reportMissingItems = new ReportMissingItems();

    @Test
    void testSolution() {
        int[] requested = {11, 2, 4, 11, 11, 2, 3};
        int[] delivered = {2, 4, 2, 11};

        int[] miss = {3, 11};
        assertArrayEquals(miss, reportMissingItems.solution(requested, delivered));
    }

    @Test
    void testEmptySolution() {
        int[] requested = {1, 3, 5, 4};
        int[] delivered = {5, 3, 1,};

        assertArrayEquals(new int[] {}, reportMissingItems.solution(requested, delivered));
    }

}