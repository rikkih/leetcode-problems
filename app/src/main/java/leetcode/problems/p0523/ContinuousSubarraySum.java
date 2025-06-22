package leetcode.problems.p0523;

import java.util.HashMap;
import java.util.Map;

/**
 * When approaching a contiguous subarray problem, a good general approach is
 * to see if we can use a Prefix Sum Map as we iterate, whilst keeping track of
 * the Cumulative Sum as we iterate.
 *
 * Since we here want to know whether the elements of any subarray is a multiple
 * of K and the array is at least two, our condition will be that the distance
 * between the current index and currentSum % k == 0.
 */
class ContinuousSubarraySum {

    boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> preFixSumToFirstIndex = new HashMap<>();
        preFixSumToFirstIndex.put(0, -1);

        int n = nums.length;
        int cumulativeSum = 0;

        for (int i = 0; i < n; i++) {
            cumulativeSum += nums[i];
            int target = cumulativeSum % k;

            if (preFixSumToFirstIndex.containsKey(target)) {
                if (i - preFixSumToFirstIndex.get(target) >= 2) {
                    return true;
                }
            }

            preFixSumToFirstIndex.putIfAbsent(target, i);
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
