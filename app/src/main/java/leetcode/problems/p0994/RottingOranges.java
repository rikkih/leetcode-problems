package leetcode.problems.p0994;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This solution looks at each fresh orange and uses BFS to check whether it can
 * reach a rotten orange. This means for each orange, we can traverse the entire
 * grid, which is O (m2 * n2) in the worst case.
 */
public class RottingOranges {

    private static final int[][] DIRECTIONS = new int[][]{ {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    private record Position(int row, int col, int level) {
    }

    /**
     * BFS over the grid until we reach a terminal state. We will want a global counter
     * that each BFS iteration increments if it discovers an orange and changes it to
     * rotting.
     *
     * EUREKA moment! start on each unrotten orange and see how long it takes to reach
     * the nearest rotten orange. The maximum value after trying each orange is the answer.
     * If any orange cannot reach an unrotten orange, return -1.
     * @param grid
     * @return
     */
    int orangesRotting(int[][] grid) {
        int maxDays = -1;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    int daysToRotFrom = bfs(grid, row, col);
                    if (daysToRotFrom < 0) {
                        return daysToRotFrom;
                    }
                    maxDays = Math.max(daysToRotFrom, maxDays);
                }
            }
        }
        return maxDays == -1 ? 0 : maxDays;
    }

    int bfs(int[][] grid, int row, int col) {
        boolean[][] visited = initialiseVisitedGrid(grid);

        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(row, col, 0));
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            Position current = queue.poll();
            System.out.println("Visiting: (" + current.row + ", " + current.col + ")");

            if (grid[current.row][current.col] == 2) {
                return current.level;
            }

            for (int[] direction : DIRECTIONS) {

                int nextRow = current.row + direction[0];
                int nextCol = current.col + direction[1];

                if (!isTerminalState(grid, visited, nextRow, nextCol)) {
                    queue.offer(new Position(nextRow, nextCol, current.level + 1));
                    visited[nextRow][nextCol] = true;
                }
            }
        }
        return -1;
    }

    boolean[][] initialiseVisitedGrid(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][];
        for (int r = 0; r < grid.length; r ++) {
            visited[r] = new boolean[grid[r].length];
        }
        return visited;
    }

    boolean isTerminalState(int[][] grid, boolean[][] visited, int row, int col) {
        return row < 0 ||
                col < 0 ||
                row >= grid.length ||
                col >= grid[row].length ||
                visited[row][col] ||
                grid[row][col] == 0;
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
