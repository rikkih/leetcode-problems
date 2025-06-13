package leetcode.problems.p0039;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return
 * a list of al unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two
 * combinations are unique if the frequency of at least one of the chosen numbers is different.
 */
public class CombinationSum {

    List<List<Integer>> generate(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, 0, candidates, combinations, target);
        return combinations;
    }

    private void backtrack(List<Integer> path,
                           int start,
                           int sum,
                           int[] candidates,
                           List<List<Integer>> combinations,
                           int target) {
        if (sum == target) {
            combinations.add(new ArrayList<>(path));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];

            backtrack(path, i, sum, candidates, combinations, target);

            path.removeLast();
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();

        int[] candidates = new int[]{ 2, 3, 6, 7 };
        int target = 7;
        var result = combinationSum.generate(candidates, target);

        System.out.println(result);
    }
}
