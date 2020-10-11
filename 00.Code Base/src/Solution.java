public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{1,2,3,4,5}));
    }

    //DP function:
    // 0: not hold the stock, 1: hold the stock
    // F(n)(0) = max(F(n-1)(0), F(n-1)(1) + a(n))
    // F(n)(1) = max(F(n-1)(1), F(n-1)(0) - a(n))
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            // because you can only buy the stock at most once, buy => -prices[i]
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }
        return dp0;
    }
}
