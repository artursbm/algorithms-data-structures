package problems.arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HourGlassTest {

    private final HourGlass hg = new HourGlass();

    @ParameterizedTest
    @MethodSource("provideInputs")
    void solutionTest(ArrayList<ArrayList<Integer>> arr, int expected) {
        assertEquals(expected, hg.solution(arr));
    }

    private static Stream<Arguments> provideInputs() {
        return Stream.of(Arguments.of(
                new ArrayList<>(List.of(
                        new ArrayList<>(List.of(1, 1, 1, 0, 0, 0)),
                        new ArrayList<>(List.of(0, 1, 0, 0, 0, 0)),
                        new ArrayList<>(List.of(1, 1, 1, 0, 0, 0)),
                        new ArrayList<>(List.of(0, 0, 2, 4, 4, 0)),
                        new ArrayList<>(List.of(0, 0, 0, 2, 0, 0)),
                        new ArrayList<>(List.of(0, 0, 1, 2, 4, 0)))),
                19));
    }
}
