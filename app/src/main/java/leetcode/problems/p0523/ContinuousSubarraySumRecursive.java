package leetcode.problems.p0523;

public class ContinuousSubarraySumRecursive {

    boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        boolean res;

        for (int i = 0; i < n; i++) {
            res = dfs(i, i, 0, nums, k);
            if (res) {
                return true;
            }
        }
        return false;
    }

    boolean dfs(int start, int i, int cumulativeSum, int[] nums, int k) {
        if (i - start >= 2 && cumulativeSum % k == 0) {
            return true;
        }

        if (i >= nums.length) {
            return false;
        }

        return dfs(start, i + 1, cumulativeSum + nums[i], nums, k);
    }

    public static void main(String[] args) {
        ContinuousSubarraySumRecursive continuousSubarraySum = new ContinuousSubarraySumRecursive();

        var result = continuousSubarraySum.checkSubarraySum(new int[]{ 2, 4, 3 }, 6);
        System.out.println(result);
    }
}
