package leetcode.problems.p0746;

public class MinCostClimbingStairs {

    int minCostClimbingStairs(int[] cost) {
        /**
         * dp[i] = minimum cost to reach step i
         *
         * To reach step 0: dp[0] = 0 (no cost yet)
         * To reach step 1: dp[1] = 0 (you can start from here directly)
         * Why both are 0? Because you can choose to start at step 0 or step 1, so there's no cost yet.
         *
         * Now for step 2 and beyond. To reach step i, you could have:
         * Come from step i - 1 and paid cost[i - 1], or
         * Come from step i - 2 and paid cost[i - 2]
         *
         * So,
         * dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
         *
         * E.G.
         * cost = [10, 15, 20]
         * Length n = 3, so we build dp[0...3]:
         *
         * dp[0] = 0
         * dp[1] = 0
         * dp[2] = min(dp[1] + cost[1], dp[0] + cost[0]) = min(0+15, 0+10) = 10
         * dp[3] = min(dp[2] + cost[2], dp[1] + cost[1]) = min(10+20, 0+15) = 15
         *
         * So dp[3] = 15 is the minimum cost to reach just beyond the last step, and that’s your final answer.
         */
        int n = cost.length;
        int[] minCost = new int[n + 1];
        minCost[0] = 0;
        minCost[1] = 0;

        for (int i = 2; i <= n; i++) {
            minCost[i] = Math.min(minCost[i-1] + cost[i-1], minCost[i-2] + cost[i-2]);
        }

        return minCost[n];
    }

    int minCostOptimalSpace(int[] cost) {
        int first = 0; // min cost to reach step i - 2
        int second = 0; // min cost to reach step i - 1

        for (int i = 2; i <= cost.length; i++) {
            int current = Math.min(second + cost[i - 1], first + cost[i - 2]);
            first = second;
            second = current;
        }
        return second;
    }

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();

        int[] cost = new int[]{ 10, 15, 20 };
        var result = minCostClimbingStairs.minCostClimbingStairs(cost);
        System.out.println(result);
    }
}
