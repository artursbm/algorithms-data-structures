package problems.hashmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class TestMethods {

    @Test
    void testPutIfAbsentAndComputeIfPresent() {
        HashMap<Integer, Integer> map = new HashMap<>();

        assertNull(map.get(1));

        map.putIfAbsent(1, 0);
        assertEquals(0, map.get(1));


        map.computeIfPresent(1, (k,v) -> Math.addExact(v, 1));
        assertEquals(1, map.get(1));


    }
}
