package problems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MinStringLenAfterDeletionTest {

    MinStringLenAfterDeletion mslad = new MinStringLenAfterDeletion();

    @Test
    void testSuccess() {
        String s = "ca";

        assertEquals(2, mslad.minimumLength(s));
    }

    @Test
    void testSuccess2() {
        String s = "cabaabac";

        assertEquals(0, mslad.minimumLength(s));
    }

    @Test
    void testSuccess3() {
        String s = "aabccabba";

        assertEquals(3, mslad.minimumLength(s));
    }

    @Test
    void testSuccess4() {
        String s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";

        assertEquals(1, mslad.minimumLength(s));
    }

    @Test
    void testSuccess5() {
        String s= "bbbbbbbbbbbbbbbbbbb";

        assertEquals(0, mslad.minimumLength(s));
    }

}