package leetcode.problems.p0416;

import java.util.Arrays;

/**
 * Firstly, this problem can be mapped to the following question. Can we find a
 * subset of this set whose sum is equal to the total sum over 2.
 *
 * If we find a partition where both sides are equal, they must sum to the total
 * sum. The sum of two equal numbers can be written 2x, and so is always even.
 *
 * If the total sum is odd, we return false. Otherwise, we try to find a subset
 * whose sum is equal to totalSum / 2.
 */
public class PartitionEqualSubsetSum {

    boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();

        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return canPartitionMemo(0, 0, target, nums, memo);
    }

    /*
    Terrible time complexity. For each num, we have two decisions, i.e., O(2^n).
    Space Complexity. 
     */
    boolean canPartitionRecursive(int index, int currentSum, int target, int[] nums) {
        if (currentSum == target) return true;
        if (currentSum > target || index >= nums.length) return false;

        boolean include = canPartitionRecursive(index + 1, currentSum + nums[index], target, nums);
        boolean exclude = canPartitionRecursive(index + 1, currentSum, target, nums);

        return include || exclude;
    }

    /**
     * We need a method that speeds this up. I.e., we need to memoize and tabulate
     * this problem.
     */
    boolean canPartitionMemo(int index, int currentSum, int target, int[] nums, Boolean[][] memo) {
        if (currentSum == target) return true;
        if (currentSum > target || index >= nums.length) return false;

        if (memo[index][currentSum] != null) {
            return memo[index][currentSum];
        }

        boolean include = canPartitionMemo(index + 1, currentSum + nums[index], target, nums, memo);
        boolean exclude = canPartitionMemo(index + 1, currentSum, target, nums, memo);

        memo[index][currentSum] = include || exclude;
        return include || exclude;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 1, 5, 11, 5 };

        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        var result = partitionEqualSubsetSum.canPartition(nums);

        System.out.println(result);
    }
}
