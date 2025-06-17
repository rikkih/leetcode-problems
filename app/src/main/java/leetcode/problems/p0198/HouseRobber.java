package leetcode.problems.p0198;

import java.util.Arrays;

public class HouseRobber {

    int rob(int[] nums) {
        /**
         * If we skip a house, we take the money from the house before.
         * If we rob from a house, we can't take from the previous adjacent house, but the one before.
         * At each house we therefore have a choice.
         * Skip, and don't take from this house, take i-1th. Rob from this house, and take the max from i-2th
         */
        int n = nums.length;

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int current = Math.max(second, nums[i] + first);
            first = second;
            second = current;
        }

        return second;
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();

        int[] nums = new int[]{ 1, 2, 3, 1 };
        var result = houseRobber.rob(nums);

        System.out.println(result);
    }
}
