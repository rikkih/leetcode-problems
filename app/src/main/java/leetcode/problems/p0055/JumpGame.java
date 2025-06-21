package leetcode.problems.p0055;

import java.util.HashMap;
import java.util.Map;

public class JumpGame {

    boolean canJump(int[] nums) {
        Map<Integer, Boolean> memo = new HashMap<>();
        return recurse(nums, 0, memo);
    }

    boolean recurse(int[] nums, int index, Map<Integer, Boolean> memo) {
        // Base Case
        if (index >= nums.length - 1) {
            return true;
        }

        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        int current = nums[index];

        while (current > 0) {
            if (recurse(nums, index + current--, memo)) {
                memo.put(index, true);
                return true;
            }
        }

        memo.put(index, false);
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 2, 3, 1, 1, 4 };

        JumpGame jumpGame = new JumpGame();
        var result = jumpGame.canJump(nums);

        System.out.println(result);
    }
}
