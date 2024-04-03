package problems;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class AddBorderTest {

  AddBorder ab = new AddBorder();

  @Test
  void testSolution() {
    String[] pic = new String[] {"abc", "ded"};
    String[] expectedPic = new String[] {"*****", "*abc*", "*ded*", "*****"};

    assertArrayEquals(expectedPic, ab.solution(pic));
  }

}