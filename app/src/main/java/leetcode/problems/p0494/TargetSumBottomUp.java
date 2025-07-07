package leetcode.problems.p0494;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TargetSumBottomUp {

    int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> prev = new HashMap<>();
        prev.put(0, 1); // One way to reach sum 0 with 0 elements.

        for (int num : nums) {
            Map<Integer, Integer> current = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : prev.entrySet()) {
                int sum = entry.getKey();
                int count = entry.getValue();

                current.put(sum + num, current.getOrDefault(sum + num, 0) + count);
                current.put(sum - num, current.getOrDefault(sum - num, 0) + count);
            }
            prev = current;
        }
        return prev.getOrDefault(target, 0);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 1, 1, 1, 1, 1 };

        TargetSumBottomUp targetSumBottomUp = new TargetSumBottomUp();

        var res = targetSumBottomUp.findTargetSumWays(nums, 3);

        System.out.println(res);
    }
}
