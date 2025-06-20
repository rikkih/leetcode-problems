package leetcode.problems.p0322;

/**
 * Step-by-Step Solution
 * 1. Define State
 * Let dp[i] be the minimum number of coins needed to make amount i.
 *
 * 2. Base Case
 * dp[0] = 0 → 0 coins to make amount 0.
 *
 * 3. State Transition
 * For each amount i from 1 to amount, try all coins:
 *
 * dp[i] = min(dp[i], dp[i - coin] + 1)  for each coin where i - coin >= 0
 * If dp[i - coin] is known, then dp[i] can be updated with dp[i - coin] + 1 (one more coin).
 *
 * Initialize dp[i] to a large number (e.g. amount + 1) to represent unreachable.
 *
 * 4. Result
 * If dp[amount] is still large (unreachable), return -1.
 *
 * Else return dp[amount]
 */
public class CoinChange2 {

    int coinChange(int[] coins, int amount) {
        // let dp[i] = the minimum amount of coins needed to make amount i.
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        // Base Case. dp[0] = 0. 0 coins are needed to make zero.
        dp[0] = 0;

        // At each step, we can choose a coin, or skip it. If we choose a coin, we're adding
        // to the amount of coins
        for (int i = 1; i <= amount; i++) {
            for (int coin: coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{ 1, 2, 5 };
        int amount = 11;

        CoinChange2 coinChange2 = new CoinChange2();
        var res = coinChange2.coinChange(coins, amount);

        System.out.println(res);
    }
}
