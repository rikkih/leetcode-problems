package leetcode.problems.p0560;

import java.util.HashMap;
import java.util.Map;

/**
 * For every element, we keep track of the current sum, we also add the prefix
 * sum at every iteration.o
 *
 * if the cumulativeSum - k is in the map, then we have an subarray of length K
 * anywhere where that prefix sum was seen.
 *
 * In this case, we keep track of the count of the prefix sums so we can add it
 * to the current count whenever we encounter currentSum - k
 */
public class SubarraySumEqualsKPrefix {

    int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int cumulativeSum = 0;

        Map<Integer, Integer> preFixSumToCount = new HashMap<>();
        // This helps if we encounter a value whose length is K.
        preFixSumToCount.put(0, 1);

        for (int i = 0; i < n; i++) {
            cumulativeSum += nums[i];
            int target = cumulativeSum - k;

            if (preFixSumToCount.containsKey(target)) {
                count += preFixSumToCount.get(target);
            }

            preFixSumToCount.put(
                    cumulativeSum,
                    preFixSumToCount.getOrDefault(cumulativeSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsKPrefix subarraySumEqualsKPrefix = new SubarraySumEqualsKPrefix();

        int[] nums = new int[]{ 1, 2, 3 };
        int k = 3;
        var res = subarraySumEqualsKPrefix.subarraySum(nums, k);

        System.out.println(res);
    }

}
