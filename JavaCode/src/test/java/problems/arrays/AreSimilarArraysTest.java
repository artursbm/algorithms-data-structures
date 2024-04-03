package problems.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

class AreSimilarArraysTest {

  AreSimilarArrays asa = new AreSimilarArrays();

  @Test
  void solutionEqualArrays() {
    int[] a = {1,2,3};
    int[] b = {1,2,3};

    assertTrue(asa.solution(a,b));
  }

  @Test
  void testOneSwapSolution() {
    int[] a = {1,2,3,4};
    int[] b = {1,4,3,2};

    assertTrue(asa.solution(a,b));
  }

  @Test
  void testAreNotSimilarArrays() {
    int[] a = {1,2,3,4};
    int[] b = {1,4,2,2};

    assertFalse(asa.solution(a,b));
  }

  @Test
  void testAreNotSimilar() {
    int[] a = {1,2,2};
    int[] b = {1,1,2};

    assertFalse(asa.solution(a,b));
  }

}