package leetcode.problems.p0003;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringRecursive {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int longestSubstringLength = 0;

        for (int i = 0; i < n; i++) {
            longestSubstringLength = Math.max(
                    longestSubstringLength,
                    dfs(i, 0, new HashSet<>(), s));
        }

        return longestSubstringLength;
    }

    int dfs(int i, int currentLength, Set<Character> seen, String s) {
        char currentChar = s.charAt(i);

        if (i >= s.length() || seen.contains(currentChar)) {
            return currentLength;
        }

        seen.add(currentChar);
        return dfs(i + 1, currentLength + 1, seen, s);
    }
}
