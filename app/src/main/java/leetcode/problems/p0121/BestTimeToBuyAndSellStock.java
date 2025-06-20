package leetcode.problems.p0121;

class BestTimeToBuyAndSellStock {
    /**
     * The intuition behind this solution is to use two pointers as we traverse the
     * array. The right pointer moves ahead, and for each iteration, it checks
     * whether the current value is greater than the value at the left pointer. If
     * so, we update the maximum profit value if this is greater than the current
     * seen maximum profit. We then move right along one. If the value at the right
     * pointer is less than or equal to the pointer at the left pointer, we move the
     * left pointer to the right pointers index, and move the right pointer forward
     * one.
     *
     * This is because all differences have already been calculated between the
     * left and right pointer indices, so we can start from the next lowest value in
     * the array of stock prices.
     */
    int solve(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock arbitrage = new BestTimeToBuyAndSellStock();

        var answer = arbitrage.solve(new int[] { 1, 5, 2, 0, 10 });
        System.out.println(answer);
    }
}
