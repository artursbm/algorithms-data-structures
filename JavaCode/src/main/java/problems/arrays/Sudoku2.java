package problems.arrays;

import java.util.HashSet;

public class Sudoku2 {

  public boolean solution(char[][] grid) {
    // check duplicates in row
    var numsInRow = new HashSet<Integer>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        if (Character.isDigit(grid[i][j]) && !numsInRow.add((int) grid[i][j])) {
          return false;
        }
      }
      numsInRow.clear();
    }

    // check duplicates in row
    var numsInCol = new HashSet<Integer>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        if (Character.isDigit(grid[j][i]) && !numsInCol.add((int) grid[j][i])) {
          return false;
        }
      }
      numsInCol.clear();
    }

    var numsInSubGrid = new HashSet<Integer>();
    for (int i = 0; i < grid.length; i += 3) {
      for (int j = 0; j < grid.length; j += 3) {
        for (int r = i; r < i + 3; r++) {
          for (int c = j; c < j + 3; c++) {
            if (grid[r][c] != '.' && !numsInSubGrid.add((int) grid[r][c])) {
              return false;
            }
          }
        }
      numsInSubGrid.clear();
      }
    }
    return true;
  }

}
