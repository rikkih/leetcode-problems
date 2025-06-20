package leetcode.problems.p1143;

import java.util.Arrays;

/**
 * We want to bring this problem into a domain where we can have a 2D binary table
 * to work out the LCS of the given strings.
 *
 * Let lcs(0, 0) be the longest common substring of text1 and text2.
 * So lcs(i, j) is the LCS of t1 and t2 of t1[i:] and t2[j:].
 *
 * Base Case: lcs(I, j) || lcs(i, J), where I=len(t1) and J= len(t2). That is, there
 * is not more subsequence to match, so
 * lcs(i, J) = lcs(I, j) = 0;
 *
 * At lcs(i, j), if they match, the character can be part of the subsequence.
 * lcs(i, j) = 1 + lcs(i + 1, j + 1);
 *
 * If they do not match:
 * lcs(i, j) = max(lcs(i+1, j), lcs(i, j+1)).
 * That is, get the max from skipping a char in t1, or skipping a char in t2.
 */
class LCSMemoisation {

    int[][] memo;

    int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return lcs(text1, text2, 0, 0);
    }

    int lcs(String a, String b, int i, int j) {
        // Base case: end of either string
        if (i == a.length() || j == b.length()) {
            return 0;
        }

        // Return memoized result if already computed
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (a.charAt(i) == b.charAt(j)) {
            // Match: add 1 and move both pointers
            memo[i][j] = 1 + lcs(a, b, i + 1, j + 1);
        } else {
            // No match: try skipping each character
            int skipA = lcs(a, b, i + 1, j);
            int skipB = lcs(a, b, i, j + 1);
            memo[i][j] = Math.max(skipA, skipB);
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        LCSMemoisation lcsMemoisation = new LCSMemoisation();

        String s1 = "abcde";
        String s2 = "ace";

        var result = lcsMemoisation.longestCommonSubsequence(s1, s2);

        System.out.println(result);
    }
}
