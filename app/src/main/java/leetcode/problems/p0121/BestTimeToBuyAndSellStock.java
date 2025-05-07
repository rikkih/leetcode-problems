package leetcode.problems.p0121;

class BestTimeToBuyAndSellStock {
    int solve(int[] prices) {
        int n = prices.length;
        int left = 0;

        while (left + 1 < n && prices[left] >= prices[left + 1]) {
            left++;
        }

        if (left == n - 1) {
            return 0;
        }

        int greatestProfit = 0;
        for (int i = left + 1; i < n; i++) {
            greatestProfit = Math.max(greatestProfit, prices[i] - prices[left]);
        }

        return greatestProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock arbitrage = new BestTimeToBuyAndSellStock();

        var answer = arbitrage.solve(new int[] { 2, 1, 2, 1, 0, 1, 2 });

        System.out.println(answer);
    }
}
