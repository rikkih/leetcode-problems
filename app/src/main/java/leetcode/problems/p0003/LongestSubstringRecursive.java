package leetcode.problems.p0003;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringRecursive {

    public int lengthOfLongestSubstring(String s) {
        int longestSubstringLength = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int longestFromI = dfs(i, 0, new HashSet<>(), s);
            longestSubstringLength = Math.max(longestSubstringLength, longestFromI);
        }

        return longestSubstringLength;
    }

    int dfs(int i, int currentLength, Set<Character> seen, String s) {
        if (i >= s.length()) {
            return currentLength;
        }

        char currentChar = s.charAt(i);
        if (seen.contains(currentChar)) {
            return currentLength;
        }

        seen.add(currentChar);
        return dfs(i + 1, currentLength + 1, seen, s);
    }
}
