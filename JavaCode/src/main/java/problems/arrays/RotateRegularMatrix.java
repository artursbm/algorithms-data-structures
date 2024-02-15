package problems.arrays;

import java.util.Arrays;

/**
 * Rotate a regular matrix by 90 degrees
 */
public class RotateRegularMatrix {

  public static void main(String[] args) {
    int[][] m = new int[][] {new int[] {1, 2, 3}, new int[]{4,5,6}, new int[]{7,8,9}};

    System.out.println(Arrays.deepToString(solution(m)));
  }

  public static int[][] solution(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {
      for (int j = i; j < n - i - 1; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - j - 1][i];
        matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
        matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
        matrix[j][n - i - 1] = temp;
      }
    }

    return matrix;
  }

}
