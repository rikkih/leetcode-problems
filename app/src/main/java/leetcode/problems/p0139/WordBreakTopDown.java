package leetcode.problems.p0139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakTopDown {

    boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        Set<String> wordSet = new HashSet<>(wordDict);

        return canBreak(0, memo, s, wordSet);
    }

    boolean canBreak(int index, Boolean[] memo, String s, Set<String> wordSet) {
        if (index == s.length()) return true;

        if (memo[index] != null) return memo[index];

        for (int end = index + 1; end <= s.length(); end++) {
            boolean doesContainWord = wordSet.contains(s.substring(index, end));
            boolean canBreak = canBreak(end, memo, s, wordSet);

            if (doesContainWord && canBreak) {
                memo[index] = true;
                return true;
            }
        }

        memo[index] = false;
        return false;
    }

    public static void main(String[] args) {
        WordBreakTopDown wordBreakTopDown = new WordBreakTopDown();
        var result = wordBreakTopDown.wordBreak("catsandog", List.of("cats","dog","sand","and","cat"));

        System.out.println(result);
    }
}
