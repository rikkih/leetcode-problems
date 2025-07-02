package leetcode.problems.p0643;

class MaxAverageSubarray {
    double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double maxSum = Double.NEGATIVE_INFINITY;
        int rollingSum = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                rollingSum -= nums[i-k];
            }
            rollingSum += nums[i];
            maxSum = Math.max(maxSum, rollingSum);
        }
        return (double) maxSum / k;
    }
}
