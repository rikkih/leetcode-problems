package leetcode.problems.p0994;

import java.util.LinkedList;
import java.util.Queue;

/**
 * For this solution, we're going to bring the time complexity down to O(m * n).
 *
 * To do this, we're going to use Multi Source BFS. This starts from all rotten oranges
 * at once and rots the fresh oranges outwards.
 *
 * That is, we first iterate over the entire grid.
 * As we iterate:
 * 1. If we encounter a rotten orange - add the position to a FIFO queue.
 * 2. If we encounter a fresh orange - increment a fresh count.
 *
 * We then use BFS on our queue of rotten orange positions, adding each valid
 * neighbouring cell while the queue is not empty.
 * As we iterate:
 * 1. We add adjacent fresh oranges to the queue. Decrement the fresh count.
 * 2. Keep track of the level we are at, which represents the numbers of days elapsed.
 *
 * At the end:
 * - If freshCount == 0 ==> daysElapsed.
 * - If freshCount > 0  ==> -1.
 */
public class RottingOrangesOptimal {

    private static final int[][] DIRECTIONS = new int[][]{ {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    private record Cell(int row, int col, int level) {
    }

    int orangesRotting(int[][] grid) {
        int rows = grid.length;

        boolean[][] visited = initVisitedGrid(grid);
        Queue<Cell> queue = new LinkedList<>();
        int freshCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new Cell(row, col, 0));
                }
                if (grid[row][col] == 1) {
                    freshCount++;
                }
            }
        }

        int daysElapsed = 0;

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            daysElapsed = current.level;

            for (int[] direction : DIRECTIONS) {
                int nextRow = current.row + direction[0];
                int nextCol = current.col + direction[1];

                // We now want to only enqueue fresh orange cells, and decrement the count.
                if (isUnvisitedFreshOrangeCell(grid, visited, nextRow, nextCol)) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new Cell(nextRow, nextCol, current.level + 1));
                    freshCount--;
                }
            }
        }
        return freshCount == 0 ? daysElapsed : -1;
    }

    boolean isUnvisitedFreshOrangeCell(int[][] grid, boolean[][] visited, int row, int col) {
        return row >= 0 &&
                row < grid.length &&
                col >= 0 &&
                col < grid[row].length &&
                !visited[row][col] &&
                grid[row][col] == 1;
    }

    boolean[][] initVisitedGrid(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][];
        for (int r = 0; r < grid.length; r++) {
            visited[r] = new boolean[grid[r].length];
        }
        return visited;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };

        RottingOranges rottingOranges = new RottingOranges();
        var answer = rottingOranges.orangesRotting(grid);

        System.out.println(answer);
    }
}
