package leetcode.problems.p0001;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    int[] solveSortedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] { left, right };
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] { -1, -1 };
    }

    int[] solveUnsortedArray(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (complements.containsKey(complement)) {
                return new int[] { complements.get(complement), i };
            }

            complements.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        var answer = twoSum.solveUnsortedArray(new int[] { 2, 7, 11, 15 }, 9);

        System.out.println("Answer: [" + answer[0] + answer[1] + "]");
    }
}
