package leetcode.problems.p0051;

import java.util.ArrayList;
import java.util.List;

class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        backtrack(0, n, board, solutions);
        return solutions;
    }

    private void backtrack(int row, int n, boolean[][] board, List<List<String>> solutions) {
        if (row == n) {
            // We have a valid solution with all rows filled.
            solutions.add(buildBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = true; // Place queen
                backtrack(row + 1, n, board, solutions);
                board[row][col] = false; // backtrack. Remove queen
            }
        }
    }

    private boolean isValid(boolean[][] board, int row, int col) {
        // Check columns above the current row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        // Check diagonal up and behind
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) return false;
        }

        // Check up and in front of
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j]) return false;
        }

        return true;
    }

    private List<String> buildBoard(boolean[][] board) {
        List<String> res = new ArrayList<>();
        for (boolean[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean cell : row) {
                sb.append(cell ? 'Q' : '.');
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        int n = 4;
        List<List<String>> solutions = nQueens.solveNQueens(n);
        for (List<String> board : solutions) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

}
