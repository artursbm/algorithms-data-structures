package problems.glovo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PairOfSocksTest {

    PairOfSocks pairOfSocks = new PairOfSocks();

    @Test
    void test() {
        int[] socks = {4,7,3,7,4,1,8};
        assertEquals(2, pairOfSocks.solution(socks));
        assertEquals(2, pairOfSocks.solutionWithSet(socks));
    }

    @Test
    void testZeroPairs() {
        int[] socks = {2,3,1};
        assertEquals(0, pairOfSocks.solution(socks));
        assertEquals(0, pairOfSocks.solutionWithSet(socks));
    }

    @Test
    void testAllSameSocks() {
        int[] socks = {2,2,2,2,2};
        assertEquals(2, pairOfSocks.solution(socks));
        assertEquals(2, pairOfSocks.solutionWithSet(socks));
    }

}