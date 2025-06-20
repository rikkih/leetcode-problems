package leetcode.problems.p0091;

import java.io.FilterOutputStream;

/**
 * "1223"
 * dp[0] = 1 -> A
 * dp[1] = dp[0] + 1 = 2 -> AB, L
 * dp[2] = dp[1] + 1 = 3 -> ABC, AV, LB
 * dp[3] = dp[2] + 2 = 4 -> ABBC, ABW, AVC, LBC, LW
 *
 * "18"
 * dp[0] = 1 -> A
 * dp[1] = dp[0] + 1 = 2 -> AH, R
 *
 * "10"
 * dp[0] = 1 -> A
 * dp[1] = dp[0] + 0 = 1 -> J
 *
 * "223"
 * dp[0] = 1 -> B
 * dp[1] = dp[0] + 1 = 2 -> BB, V
 * dp[2] = dp[1] + 1  -> BBC, VC, BW
 */
public class DecodeWays {

    /**
     * To start with, we can try brute force solution. Recursive Top Down.
     * @param s
     * @return
     */
    int numDecodings(String s) {
        return recurse(s, 0);
    }

    int recurse(String s, int index) {
        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        int count = recurse(s, index + 1);

        if (index + 1 < s.length()) {
            Integer twoDigit = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                count += recurse(s, index + 2);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "226";
        DecodeWays decodeWays = new DecodeWays();

        var res = decodeWays.numDecodings(s);

        System.out.println(res);
    }
}
