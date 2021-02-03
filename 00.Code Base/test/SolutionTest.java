import org.testng.annotations.Test;

import org.testng.Assert;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();
        System.out.println(1 << 1);
        int result = sol.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        Assert.assertEquals(result, 6);
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int len = prices.length;
        int[] dp = new int[5];
        dp[1] = -prices[0];
        dp[2] = Integer.MIN_VALUE;
        dp[3] = Integer.MIN_VALUE;
        dp[4] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            //dp[0] = 0;
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[4] = Math.max(dp[4], dp[3] + prices[i]);
            System.out.printf(".");
        }
        return Math.max(0, Math.max(dp[2], dp[4]));
    }
}