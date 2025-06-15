package leetcode.problems.p0239;

/**
 * This is an O(nk) solution, where n = |nums|.
 * This can grow to be exponential in time when k >> 1, and n large.
 */
class SlidingWindowMaximumNested {

    int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] maximums = new int[n - k + 1];

        for (int left = 0; left <= n - k; left ++) {
            int max = Integer.MIN_VALUE;
            for (int i = left; i < left + k; i++) {
                max = Math.max(nums[i], max);
            }
            maximums[left] = max;
        }
        return maximums;
    }

    public static void main(String[] args) {

        int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        SlidingWindowMaximumNested slidingWindowMaximum = new SlidingWindowMaximumNested();
        var answer = slidingWindowMaximum.maxSlidingWindow(nums, 3);

        for (int num : answer) {
            System.out.print(num + ", ");
        }
    }
}
