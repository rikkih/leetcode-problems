package leetcode.problems.p0077;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * NB: that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 */
public class Combinations {

    List<List<Integer>> generate(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), combinations);
        return combinations;
    }

    void backtrack(int n, int k, int start, List<Integer> currentPath, List<List<Integer>> combinations) {
        if (currentPath.size() == k) {
            combinations.add(new ArrayList<>(currentPath));
            return;
        }

        for (int i = start; i <= n; i++) {
            currentPath.add(i);
            backtrack(n, k, i + 1, currentPath, combinations);
            currentPath.removeLast();
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;

        Combinations combinations = new Combinations();
        var answer = combinations.generate(n, k);

        System.out.println(answer);
    }
}
