package greedy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContainerWithMostWaterTest {

    private final ContainerWithMostWater container = new ContainerWithMostWater();

    @Test
    void testSuccess() {
        assertEquals(17, container.solution(new int[] {2,3,4,5,18,17,6}));
    }

}