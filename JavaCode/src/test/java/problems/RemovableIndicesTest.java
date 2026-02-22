package problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemovableIndicesTest {

    RemovableIndices ri = new RemovableIndices();

    @Test
    public void testGetRemovableIndices() {

        var str1 = "aabbb";
        var str2 = "aabb";

        assertEquals(List.of(2, 3, 4), ri.getRemovableIndices(str1, str2));

        str1 = "mmgghh";
        str2 = "mfggh";

        assertEquals(List.of(-1), ri.getRemovableIndices(str1, str2));
    }
}
