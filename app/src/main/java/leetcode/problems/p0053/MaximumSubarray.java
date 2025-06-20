package leetcode.problems.p0053;

/**
 * Brute force solution is to generate all subarray and take their sum. O(n!).
 *
 * We could probably do this in O(n) with some kind of storage mechanism.
 *
 * Let dp[i] be the maximum subarray sum of length i.
 * So dp[0] is 0. The maximum subarray sum of length 0 is 0.
 * For each {num : nums}
 *   dp[i] =
 */
public class MaximumSubarray {

    int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Choose whether to extend the current subarray or start a new one.
            currentMax = Math.max(nums[i], nums[i] + currentMax);
            globalMax = Math.max(currentMax, globalMax);
        }

        return globalMax;
    }

    int maxSubArrayDp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            maxSum = Math.max(dp[i], maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();

        int[] nums = new int[]{ 5, 4, -1, 7, 8 };
        maximumSubarray.maxSubArray(nums);
    }
}
