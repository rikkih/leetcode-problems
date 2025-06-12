package leetcode.problems.p0078;

import java.util.ArrayList;
import java.util.List;

class Subsets {

    public List<List<Integer>> generate(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i + 1, nums, current, result);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        var allSubsets = subsets.generate(new int[]{ 1, 2 ,3 });

        System.out.println(allSubsets);
    }
}
