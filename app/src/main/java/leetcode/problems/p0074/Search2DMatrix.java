package leetcode.problems.p0074;

/**
 * - Must solve in O(log(m*n)) -> Some sort of Binary Search
 *
 * - To start with, our target could be in any row. We can find which row it could
 *   be contained in by performing BS over the first index of the rows.
 *
 * - Once we find the row (it could be the first value, return early)
 *   Perform BS on that row to find the target, return false if not.
 */
public class Search2DMatrix {

    boolean searchMatrix(int[][] matrix, int target) {
        int index = findCandidateRow(matrix, target);
        return arrayContains(matrix[index], target);
    }

    private boolean arrayContains(int[] array, int target) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    private int findCandidateRow(int[][] matrix, int target) {
        int top = 0, bottom = matrix.length - 1;

        while (top < bottom) {
            int mid = top + (bottom - top + 1) / 2;

            if (matrix[mid][0] < target) {
                top = mid;
            } else {
                bottom = mid - 1;
            }
        }
        return top;
    }


    public static void main(String[] args) {
        Search2DMatrix search2DMatrix = new Search2DMatrix();

        int[][] matrix = new int[][] {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 13;

        System.out.println(search2DMatrix.searchMatrix(matrix, target));
    }
}
