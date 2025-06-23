package leetcode.problems.p0240;

/**
 * If we start at the top-right or the bottom left. This only works on proper
 * rectangular matrices.
 *
 * Top Right:
 *  if target greater: column down
 *    else: row left
 */
public class Search2DMatrixIIEfficient {

    boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
