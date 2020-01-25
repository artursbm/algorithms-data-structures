package problems;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Artur Mello
 * * * * * 25 Jan 2020 * * * * *
 * <p>
 * This program takes an array of arrays, which describes a wall with bricks that has integer sizes, and are placed in a way that all
 * rows of the wall has the same length. The main goal of this program is to find the line that crosses the least number of bricks on the
 * wall.
 * <p>
 * This implementation focuses on finding the maximum number of edges crossed, which will minimize the number of bricks crossed by the line.
 * Considering that the array of arrays, or the wall, contains N rows and M bricks in each row, the complexity in
 * Big-O notation will be O(N*M) for this implementation.
 * <p>
 * This program will assume that the wall will always have less than 20000 bricks (elements in the "matrix"), and it's rows or columns
 * won't exceed 10000 elements each.
 */
public class CrossedWall {
    public static void main(String[] args) {

        int result1 = getMinimumNumberOfBricksCrossed(createWallOfBricks());
        System.out.println(result1);

        int result2 = getMinimumNumberOfBricksCrossed(createWallOfBricks2());
        System.out.println(result2);

        int result3 = getMinimumNumberOfBricksCrossed(createWallOfBricks3());
        System.out.println(result3);


    }

    private static int getMinimumNumberOfBricksCrossed(List<List<Integer>> wall) {
        // the size of the wall, or the number of rows in the array of arrays.
        int heightWall = wall.size();
        // get the width of the wall (sum of all brick lengths), which gives the number of edges +1
        // (represented by the left border of the wall)
        int numberOfEdges = wall.get(0).stream().reduce(Integer::sum).get();

        int edgeCuts[] = new int[numberOfEdges];
        // set the first edge to minimum integer value, just to ensure it won't count as valid edge (it's the border of the wall).
        edgeCuts[0] = Integer.MIN_VALUE;

        for (int i = 0; i < heightWall; i++) {
            int k = 0;
            int numberOfBricks = wall.get(i).size();
            for (int j = 0; j < numberOfBricks; j++) {
                int brickSize = wall.get(i).get(j);
                if (k + brickSize < numberOfEdges) {
                    k += brickSize;
                    edgeCuts[k] += 1;
                }
            }
        }
        // This will sort the array, so the last element will represent the column with the maximum number of edges crossed by the line
        // on the wall. The result will be the difference between the height of the wall and the maximum number of edges crossed, which
        // gives the number of bricks crossed by the same line.
        Arrays.sort(edgeCuts);
        return heightWall - edgeCuts[numberOfEdges - 1];
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
