package leetcode.problems.p0494;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    int bruteForce(int[] nums, int target) {
        if (target > Math.abs(Arrays.stream(nums).sum())) return 0;

        Map<String, Integer> memo = new HashMap<>();
        return targetSumRecursive(0, 0, target, nums, memo);
    }

    int targetSumRecursive(int idx, int currentSum, int target, int[] nums, Map<String, Integer> memo) {
        if (idx == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        String key = idx + "." + currentSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int added = targetSumRecursive(idx + 1, currentSum + nums[idx], target, nums, memo);
        int subtracted = targetSumRecursive(idx + 1, currentSum - nums[idx], target, nums, memo);

        int result = added + subtracted;
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        var result = targetSum.bruteForce(new int[]{1, 2, 3}, 0);
        System.out.println(result);
    }
}
