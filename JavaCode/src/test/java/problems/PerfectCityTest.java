package problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PerfectCityTest {

    private final PerfectCity perfectCity = new PerfectCity();

    @Test
    void successTest() {
        var dep = new double[] {0.4, 1};
        var des = new double[] {0.9, 3};

        assertEquals(2.7, perfectCity.solution(dep, des));
    }

    @Test
    void successTestMidWay() {
        var dep = new double[] {0.5, 1};
        var des = new double[] {0.5, 3};

        assertEquals(3, perfectCity.solution(dep, des));
    }

    @Test
    void testDepFarFromDes() {
        var dep = new double[] {3.4, 1};
        var des = new double[] {5.5, 3};

        assertEquals(4.1, perfectCity.solution(dep, des));
    }

    @Test
    void testCase() {
        var dep = new double[] {2.4, 1};
        var des = new double[] {5, 7.3};

        assertEquals(8.9, perfectCity.solution(dep, des));
    }

    @Test
    void testCaseDepartureNonIntegerYAxis() {
        var dep = new double[] {0, 0.4};
        var des = new double[] {1, 0.6};

        assertEquals(2.0, perfectCity.solution(dep, des));
    }

}