package leetcode.problems.p0494;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    record IndexTotalPair(int index, int total) {}

    public int findTargetSumWays(int[] nums, int target) {
        Map<IndexTotalPair, Integer> cache = new HashMap<>();
        return search(0, 0, nums, target, cache);
    }

    private int search(int index, int currentSum, int[] nums, int target, Map<IndexTotalPair, Integer> cache) {
        IndexTotalPair key = new IndexTotalPair(index, currentSum);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        int add = search(index + 1, currentSum + nums[index], nums, target, cache);
        int subtract = search(index + 1, currentSum - nums[index], nums, target, cache);

        cache.put(key, add + subtract);
        return add + subtract;
    }

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();

        var res = targetSum.findTargetSumWays(new int[]{ 1, 1, 1 }, 1);
        System.out.println(res);
    }
}
