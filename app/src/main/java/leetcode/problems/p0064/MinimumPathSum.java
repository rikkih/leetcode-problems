package leetcode.problems.p0064;

/**
 * The answer to this solution lies in the heart of recognising that this problem can be
 * broken down in to optimal sub solutions.
 * <p>
 * That is, for every square on the grid, the minimum path to that square is the minimum
 * path from the square on the left, or the minimum path from the square above, plus the
 * value on this square.
 * <p>
 * Thus, to answer this problem, we can iterate over each square and calculate the
 * minimum path to reach that square. The answer will be the value of the bottom right
 * most square.
 */
class MinimumPathSum {

    int find(int[][] grid) {
        // Firstly, get the minimum paths for each square of the first row and first
        // column.
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int j = 1; j < grid[0].length; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // Iterate over the rest of the grid.
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
//        int[][] grid = {
//                {1, 3, 1},
//                {1, 5, 1},
//                {4, 2, 1}
//        };
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6}
        };
        MinimumPathSum pathSum = new MinimumPathSum();
        var result = pathSum.find(grid);
        System.out.println(result);
    }

}
