package leetcode.problems.p0518;

/**
 * We can use Dynamic Programming for this problem, as the template of the problem
 * is the same as Coin Change I.
 *
 * We start by initialising an array of size `amount + 1`. This is to account for the
 * zeroth base case.
 *
 * For each amount, we want to find how many combinations there are of the coins in
 * coins to make up the value of amount. We can work this out in a similar way.
 *
 * The ordering here does not matter, so [1, 2, 1] == [2, 1, 1].
 *
 * This means we can, for each coin, see how many ways there are to make the given
 * amount. With the example ([1, 2, 5], 6), we first look at how many times coin 1 can
 * make each amount.
 */
class CoinChangeII {

    int solve(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        memo[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                memo[i] = memo[i] + memo[i - coin];
            }
        }

        return memo[amount];
    }

    public static void main(String[] args) {
        CoinChangeII coinChangeII = new CoinChangeII();

        int[] coins = new int[]{ 1, 2, 5 };
        int amount = 5;
        int answer = coinChangeII.solve(coins, amount);

        System.out.println(answer);
    }
}
