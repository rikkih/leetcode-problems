package leetcode.problems.p0198;

import java.util.Arrays;

public class HouseRobber {

    int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return 0;
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();

        int[] nums = new int[]{ 1, 2, 3, 1 };
        var result = houseRobber.rob(nums);

        System.out.println(result);
    }
}
