package problems.arrays;

import java.util.ArrayList;

public class HourGlass {
    public int solution(ArrayList<ArrayList<Integer>> arr) {
        var window = new int[][]{
                {1, 1, 1},
                {0, 1, 0},
                {1, 1, 1}};

        var hgMaxSum = Integer.MIN_VALUE;
        var hgSum = 0;
        // I have a window mask that I can use to identify the values of the hour glass


        // I'll iterate over the values of the window to find the sum of the HG

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                hgSum = 0;
                for (int k = i; k < i + 3; k++) {
                    // inside the lines of the HG window:
                    for (int v = j; v < j + 3; v++) {
                        hgSum += arr.get(k).get(v) * window[k - i][v - j];
                    }
                }
                hgMaxSum = Math.max(hgSum, hgMaxSum);
            }
        }
        return hgMaxSum;
    }
}
