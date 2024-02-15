package problems.arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Sudoku2Test {

  private Sudoku2 sudoku2 = new Sudoku2();

  @Test
  void testSuccessCase() {
    char[][] sudoku = new char[][] {
        new char[] {'.', '.', '.', '1', '4', '.', '.', '2', '.'},
        new char[] {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
        new char[] {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
        new char[] {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
        new char[] {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
        new char[] {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
        new char[] {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
        new char[] {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
        new char[] {'.', '.', '.', '5', '.', '.', '.', '7', '.'}
    };

    assertTrue(sudoku2.solution(sudoku));
  }

  @Test
  void testFalseCase() {
    char[][] sudoku = new char[][] {
        new char[] {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
        new char[] {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
        new char[] {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
        new char[] {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
        new char[] {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
        new char[] {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
        new char[] {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
        new char[] {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
        new char[] {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
    };

    assertFalse(sudoku2.solution(sudoku));
  }
}