package leetcode.problems.p0240;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * BFS, keep track of visited.
 *
 * If target > matrix[i][j]
 *   queue.offer(i+i, j)
 *   queue.offer(i, j+1)
 *
 * else
 *   queue.offer(i-1, j)
 *   queue.offer(i, j-1)
 */
class Search2DMatrixII {

    record Cell(int i, int j) {}

    boolean searchMatrix(int[][] matrix, int target) {
        Set<Cell> visited = new HashSet<>();
        Queue<Cell> queue = new LinkedList<>();

        Cell startCell = getMidCell(matrix);
        queue.offer(startCell);

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            if (visited.contains(current)) {
                continue;
            }

            visited.add(current);

            int i = current.i(), j = current.j();

            if (matrix[i][j] == target) {
                return true;
            }

            if (matrix[i][j] > target) {
                if (i - 1 >= 0) queue.offer(new Cell(i - 1, j));
                if (j - 1 >= 0) queue.offer(new Cell(i, j - 1));
            } else {
                if (i + 1 < matrix.length) queue.offer(new Cell(i + 1, j));
                if (j + 1 < matrix[i].length) queue.offer(new Cell(i, j + 1));
            }
        }
        return false;
    }

    Cell getMidCell(int[][] matrix) {
        int rows = matrix.length;
        int midRow = rows / 2;

        int cols = matrix[midRow].length;
        int midCol = cols / 2;

        return new Cell(midRow, midCol);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10,13,14,17, 24},
                {18,21,23,26, 30}
        };

        int target = 30;

        Search2DMatrixII search2DMatrixII = new Search2DMatrixII();
        var res = search2DMatrixII.searchMatrix(matrix, target);

        System.out.println(res);
    }
}
