package leetcode.problems.p1143;

/**
 * NB: We just want the length of this subsequence.
 *
 * Well, we'll need to generate every subsequence of the shortest string.
 * This will contain the longest common substring that can exist.
 *
 * To brute force this, we can then check if that substring exists in the other
 * substring.
 *
 * For each check, we'll have a valid sequence of characters from the shorter
 * string.
 * At each point, we check if these characters are a common subsequence in the other
 * string.
 * We continue until we reach an invalid index of the string.
 *
 * To make this a bit faster, we could memoise this in some way.
 */
public class LongestCommonSubsequence {

    int longestCommonSubsequence(String text1, String text2) {
        String shorter = text1.length() <= text2.length() ? text1 : text2;
        String longer = shorter.equals(text1) ? text2 : text1;
        return findRecursively(shorter, longer, 0, new StringBuilder());
    }

    int findRecursively(String shorter, String longer, int index, StringBuilder candidates) {
        int max = 0;

        if (isSubsequence2(longer, candidates.toString())) {
            max = candidates.length();
        }

        if (index >= shorter.length()) {
            return max;
        }

        // Include current char
        StringBuilder withCurrent = new StringBuilder(candidates).append(shorter.charAt(index));
        int include = findRecursively(shorter, longer, index + 1, withCurrent);

        // Exclude current char
        int exclude = findRecursively(shorter, longer, index + 1, new StringBuilder(candidates));

        return Math.max(max, Math.max(include, exclude));
    }

    // There is a fault in this logic.
    boolean isSubsequence(String str, String subsequence) {
        int left = 0;
        for (char c : subsequence.toCharArray()) {
            while (c != str.charAt(left)) {
                left ++;
                if (left >= str.length()) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isSubsequence2(String str, String subsequence) {
        int i = 0, j = 0;

        while (i < str.length() && j < subsequence.length()) {
            if (str.charAt(i) == subsequence.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == subsequence.length();
    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();

        var result = longestCommonSubsequence.longestCommonSubsequence("bsbininm", "jmjkbkjkv");

        System.out.println(result);
    }
}
