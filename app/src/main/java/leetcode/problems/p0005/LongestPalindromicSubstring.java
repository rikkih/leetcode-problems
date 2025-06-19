package leetcode.problems.p0005;

/**
 * A naive solution could be to just check every substring. We can do this with
 * depth first search over the string.
 */
public class LongestPalindromicSubstring {

    String longestPalindrome(String s) {
        if (s.length() < 1) return "";

        // Initial values. E.G. if |s| = 1.
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int lenOdd = expandAround(s, i, i);
            int lenEven = expandAround(s, i, i+1);
            int len = Math.max(lenOdd, lenEven);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // substring is exclusive of end, so add 1.
        return s.substring(start, end + 1);
    }

    int expandAround(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        String result = longestPalindromicSubstring.longestPalindrome("babad");
        System.out.println(result);
    }
}
