package leetcode.problems.p0074;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Search2DMatrixTest {

    private final Search2DMatrix search2DMatrix = new Search2DMatrix();

    @Test
    void givenMatrixWithTarget_shouldReturnTrue() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        assertTrue(search2DMatrix.searchMatrix(matrix, 3));
    }

    @Test
    void givenMatrixWithOneValueAndNoTarget_shouldReturnFalse() {
        int[][] matrix = {
                {1},
        };

        assertTrue(search2DMatrix.searchMatrix(matrix, 2));
    }
}