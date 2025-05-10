package leetcode.problems.p0283;

import java.util.Arrays;

class MoveZeroes {
    void solveWithSwap(int[] nums) {
        int lastZero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[lastZero];
                nums[lastZero] = nums[i];
                nums[i] = temp;
                lastZero++;
            }
        }
    }

    void solveWithForwardPass(int[] nums) {
        // TODO
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();

        var testCase = new int[] { 1, 0, 1, 0, 3, 12 };

        moveZeroes.solveWithSwap(testCase);
        System.out.println(Arrays.toString(testCase));
    }
}
