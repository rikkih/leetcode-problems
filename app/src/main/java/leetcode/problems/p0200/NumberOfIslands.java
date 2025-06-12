package leetcode.problems.p0200;

class NumberOfIslands {

    int solve(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    // Island found. Traverse neighbours until we've seen every land node on this island.
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int r, int c) {
        // Base Case. Here we just return if we're out of bounds or see a zero.
        if (isTerminalNode(grid, r, c)) {
            return;
        }

        // Mark it as a terminal node.
        grid[r][c] = '0';

        // Continue traversal on neighbours.
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
    }

    boolean isTerminalNode(char[][] grid, int r, int c) {
        return r < 0 ||
                c < 0 ||
                r > grid[0].length ||
                c > grid.length ||
                grid[r][c] == '0';
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        var answer = numberOfIslands.solve(grid);

        System.out.println(answer);
    }
}
