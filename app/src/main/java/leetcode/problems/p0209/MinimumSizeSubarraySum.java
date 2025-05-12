package leetcode.problems.p0209;

class MinimumSizeSubarraySum {
    int solve(int target, int[] nums) {
        int left = 0;
        int leastLength = Integer.MAX_VALUE;
        int sumOfCurrentWindow = 0;

        for (int right = 0; right < nums.length; right++) {
            sumOfCurrentWindow += nums[right];

            while (sumOfCurrentWindow >= target) {
                leastLength = Math.min(leastLength, right - left + 1);
                sumOfCurrentWindow -= nums[left++];
            }
        }
        return leastLength == Integer.MAX_VALUE ? 0 : leastLength;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();

        var answer = minimumSizeSubarraySum.solve(7, new int[] { 2, 3, 1, 2, 4, 3 });
        System.out.println(answer);
    }
}
