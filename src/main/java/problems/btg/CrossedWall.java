package problems.btg;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Artur Mello
 * * * * * 27 Jan 2020 * * * * *
 * <p>
 * This program takes an array of arrays, which describes a wall with bricks that has integer sizes, and are placed in a way that all
 * rows of the wall has the same length. The main goal of this program is to find the line that crosses the least number of bricks on the
 * wall.
 * <p>
 * This implementation focuses on finding the maximum number of edges crossed, which will minimize the number of bricks crossed by the line.
 * Considering that the 2-D array is converted to a 1-D array of n elements (bricks), and that the solution iterates over all the
 * elements of the array, the time complexity analysis results in a O(n) execution time, considering Big-O notation. The space complexity
 * is O(n), since the maximum allocation of memory is made by the array representing all the bricks in the wall.
 * <p>
 *
 */
public class CrossedWall {

    public static void main(String[] args) {

        int res = EdgeCuts.getMinBricksCrossed(createWallOfBricks());
        System.out.println(res);

        int res2 = EdgeCuts.getMinBricksCrossed(createWallOfBricks2());
        System.out.println(res2);

        int res3 = EdgeCuts.getMinBricksCrossed(createWallOfBricks3());
        System.out.println(res3);

    }

    private static List<List<Integer>> createWallOfBricks() {
        List<List<Integer>> wall = new ArrayList<>();
        Integer row1[] = {1, 2, 2, 1};
        Integer row2[] = {3, 1, 2};
        Integer row3[] = {1, 3, 2};
        Integer row4[] = {2, 4};
        Integer row5[] = {3, 1, 2};
        Integer row6[] = {1, 3, 1, 1};

        wall.add(Arrays.asList(row1));
        wall.add(Arrays.asList(row2));
        wall.add(Arrays.asList(row3));
        wall.add(Arrays.asList(row4));
        wall.add(Arrays.asList(row5));
        wall.add(Arrays.asList(row6));
        return wall;
    }

    private static List<List<Integer>> createWallOfBricks2() {
        List<List<Integer>> wall = new ArrayList<>();
        Integer row1[] = {4};
        Integer row2[] = {4};
        Integer row3[] = {4};

        wall.add(Arrays.asList(row1));
        wall.add(Arrays.asList(row2));
        wall.add(Arrays.asList(row3));
        return wall;
    }

    private static List<List<Integer>> createWallOfBricks3() {
        List<List<Integer>> wall = new ArrayList<>();
        Integer row1[] = {1, 1};
        Integer row2[] = {1, 1};
        Integer row3[] = {1, 1};
        Integer row4[] = {1, 1};
        Integer row5[] = {1, 1};

        wall.add(Arrays.asList(row1));
        wall.add(Arrays.asList(row2));
        wall.add(Arrays.asList(row3));
        wall.add(Arrays.asList(row4));
        wall.add(Arrays.asList(row5));
        return wall;
    }
}
