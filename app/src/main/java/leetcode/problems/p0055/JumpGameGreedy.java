package leetcode.problems.p0055;

public class JumpGameGreedy {

    boolean canJump(int[] nums) {
        // [3, 2, 1, 0, 4]
        // [2, 3, 1, 1, 4]
        int index = 0;
        int reachable = 0;

        while (index < nums.length) {
            if (index > reachable) return false;
            reachable = Math.max(reachable, nums[index] + index); // where we can reach from the current index.
            index++;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 2, 3, 1, 1, 4 };

        JumpGameGreedy jumpGameGreedy = new JumpGameGreedy();

        var result = jumpGameGreedy.canJump(nums);
        System.out.println(result);
    }
}
