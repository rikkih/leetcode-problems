package leetcode.problems.p0647;

public class PalindromicSubstring {

    int countSubstrings(String s) {
        int n = s.length();
        int palindromeCount = 0;

        for (int i = 0; i < n; i++) {
            palindromeCount += expandAround(s, i, i); // Odd count
            palindromeCount += expandAround(s, i, i+1); // Even count
        }

        return palindromeCount;
    }

    int expandAround(String s, int left, int right) {
        int count = 0;
        while (palindromicCondition(s, left, right)) {
            count++;
            right++;
            left--;
        }
        return count;
    }

    private boolean palindromicCondition(String s, int left, int right) {
        return left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right);
    }
}
