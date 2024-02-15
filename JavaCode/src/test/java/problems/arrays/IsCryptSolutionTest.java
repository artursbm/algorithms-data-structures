package problems.arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IsCryptSolutionTest {

  private IsCryptSolution isCryptSolution = new IsCryptSolution();

  @Test
  void testTrueScenario() {
    String[] crypt = new String[] {"SEND", "MORE", "MONEY"};
    char[][] solution = new char[][] {
        new char[] {'O', '0'},
        new char[] {'M', '1'},
        new char[] {'Y', '2'},
        new char[] {'E', '5'},
        new char[] {'N', '6'},
        new char[] {'D', '7'},
        new char[] {'R', '8'},
        new char[] {'S', '9'}
    };
    assertTrue(isCryptSolution.solution(crypt, solution));
  }

}