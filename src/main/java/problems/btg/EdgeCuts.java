package problems.btg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EdgeCuts {

    private static int MAX_WALL_SIZE = 10000;

    /**
     * @implNote This implementation is better than getMinimumNumberOfBricksCrossed, because it runs in linear time complexity in worst case
     * which gives it Big-O notation of O(n), being n the number of elements in the array formed by all the bricks in the wall
     * @implSpec This implementation transforms the wall (an array of arrays) into a 1-D List, which gives it the possibility to be
     * traversed linearly. The program starts defining the width of the wall, which is the same at each row. Then, the wall is
     * transformed into a List, and, iterating on each element (brick), a flag checks if the iteration reached the end of the wall row. If
     * that happens, the flag is zeroed. On every iteration, the vector edgeCuts adds one to the position in which the current brick has its
     * edge.
     * <p>
     * The program ends by making both the borders of the wall not being counted as edges, and the result of how many bricks are
     * cut but the line is the difference between the number of rows in the wall and the maximum number of edges cut by the line.
     **/
    public static int getMinBricksCrossed(List<List<Integer>> wall) {
        int wallWidth = wall.get(0).stream().reduce(Integer::sum).get();

        if (wallWidth >= Integer.MAX_VALUE) {
            throw new ArithmeticException("Comprimento máximo do muro ultrapassado");
        }

        int[] edgeCuts = new int[wallWidth + 1];
        int flagWidth = 0;

        List<Integer> wallLine = new ArrayList<>();

        wall.forEach(wallLine::addAll);

        if (wallLine.size() >= MAX_WALL_SIZE) {
            throw new ArithmeticException("Número de tijolos do muro excedido (maior que 10000.");
        }

        for (Integer brickSize : wallLine) {
            if (flagWidth + brickSize > wallWidth) {
                flagWidth = 0;
            }
            flagWidth += brickSize;
            edgeCuts[flagWidth] += 1;
        }

        edgeCuts[wallWidth] = Integer.MIN_VALUE;
        edgeCuts[0] = Integer.MIN_VALUE;
        Arrays.sort(edgeCuts);

        return wall.size() - edgeCuts[wallWidth];
    }

    public static int getMinimumNumberOfBricksCrossed(List<List<Integer>> wall) {
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
                    edgeCuts[k]++;
                }
            }
        }
        // This will sort the array, so the last element will represent the column with the maximum number of edges crossed by the line
        // on the wall. The result will be the difference between the height of the wall and the maximum number of edges crossed, which
        // gives the number of bricks crossed by the same line.
        Arrays.sort(edgeCuts);
        return heightWall - edgeCuts[numberOfEdges - 1];
    }
}
