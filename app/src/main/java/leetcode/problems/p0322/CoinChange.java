package leetcode.problems.p0322;

import java.util.HashMap;
import java.util.Map;

/**
 * This problem can be broken down into the optimal sub solutions for each amount
 * that is less than `amount`.
 *
 * For example, say we have coins [1, 2, 5], and the amount is 11. The optimal solution
 * to amount 11 is 5 + 5 + 1. It's important to see that the minimal solution to 11,
 * which we can denote M(11), can be written as M(11) = 1 + M(10) + M(5). That is, if
 * we can reach 11, the minimum amount of coins needed can be worked out from the
 * minimum number of coins for amount 10, 9, or 6.
 *
 * M(11) = 3 -> 5 + 5 + 1
 * M(10) = 2 -> 5 + 5
 * M(5) = 1 -> 5
 *
 * Thus, we can work our way up from the minimum to achieve value 1, all the way up to
 * 11, iterating over each coin for each amount.
 *
 * If an amount is greater than the value of a coin, we discard that.
 *
 * [3, 4], 5
 */
class CoinChange {

    int solve(int[] coins, int amount) {
        int[] memo = new int[amount + 1];

        // Give each amount a solution too large.
        for (int i = 1; i <= amount; i++) {
            memo[i] = amount + 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);
                }
            }
        }
        return memo[amount] > amount ? -1 : memo[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;

        CoinChange coinChange = new CoinChange();
        var answer = coinChange.solve(coins, amount);

        System.out.println(answer);
    }
}
