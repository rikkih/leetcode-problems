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

    /**
     * We want to try and map this problem on to the subset sum problem.
     *
     * One thing we can see is that 0 <= nums[i] <= 1000, so all elements are positive.
     * Each element will be assigned a plus or negative symbol. That is,
     *
     * sum(+) - sum(-) = target; we also know that
     * sum(+) + sum(-) = totalSum;
     * ==>
     * 2 * sum(+) = totalSum + target;
     * ==>
     * sum(+) = (target + totalSum) / 2;
     *
     * Thus, we need to find a subset whose sum is equal to (target + totalSum) / 2
     * @param nums
     * @return
     */
    int targetSumIterative(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        if ((target + total) % 2 != 0 || Math.abs(target) > total) return 0;

        int subsetSum = (target + total) / 2;

        // dp[i] = the number of ways to pick elements from nums[] such that they sum to i.
        // So dp[0] = 1 initially — there's 1 way to sum to zero: pick nothing.
        // "If we already know how many ways to make sum i - num, then we can make sum i by adding num to those combinations."
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = subsetSum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[subsetSum];
    }

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        var result = targetSum.targetSumIterative(new int[]{1, 2, 3}, 0);
        System.out.println(result);
    }
}
