package leetcode.problems.p0240;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Search2DMatrixIIEfficientTest {

    Search2DMatrixIIEfficient uut = new Search2DMatrixIIEfficient();

    @Test
    public void givenArrayWithTarget_shouldReturnTrue() {
        int[][] matrix = new int[][] {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};
        int target = 20;
        assertFalse(uut.searchMatrix(matrix, target));
    }



}