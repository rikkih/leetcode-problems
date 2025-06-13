package leetcode.problems.p0046;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
class Permutations {

    List<List<Integer>> generate(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(new ArrayList<>(), used, permutations, nums);
        return permutations;
    }

    private void backtrack(List<Integer> currentPath, boolean[] used, List<List<Integer>> permutations, int[] nums) {
        if (currentPath.size() == nums.length) {
            permutations.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            currentPath.add(nums[i]);
            used[i] = true;

            backtrack(currentPath, used, permutations, nums);

            currentPath.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{ 1, 2, 3, 4, 5 };

        Permutations permutations = new Permutations();
        List<List<Integer>> allPermutations = permutations.generate(nums);

        System.out.println(allPermutations.size());
    }
}
