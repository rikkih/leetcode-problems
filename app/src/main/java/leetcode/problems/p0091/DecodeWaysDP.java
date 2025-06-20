package leetcode.problems.p0091;

/**
 * Let dp[i] be the number of decodings at length i.
 * dp[0] = 1. Empty String
 * dp[1] = 1. First character, as long as its valid (not equal to 0).
 * dp[2] += dp[1]  1-digit
 * dp[2] += dp[0]  2-digit
 *
 */
public class DecodeWaysDP {


    int numDecondings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        // "123"
        // dp[i] is number of decodings for first i characters.
        for (int i = 2; i < s.length(); i++) {
            Integer oneDigit = Integer.parseInt(s.substring(i - 1, i));
            Integer twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit != 0) {
                dp[i] += dp[i-1];
            }

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "226";
        DecodeWays decodeWays = new DecodeWays();

        var res = decodeWays.numDecodings(s);

        System.out.println(res);
    }
}
