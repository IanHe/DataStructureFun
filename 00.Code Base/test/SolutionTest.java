import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assertEquals(solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}), 6);
        assertEquals(solution.maxProfit(new int[]{1, 2, 3, 4, 5}), 4);
        assertEquals(solution.maxProfit(new int[]{7, 6, 4, 3, 1}), 0);
    }
}

class Solution {
    /*
        i: 0 -> len-1
        dp0 = max(dp0, -prices[i])  // the first time buy stock
        dp1 = max(dp1, dp0 + prices[i]) // the first time sell stock
        dp2 = max(dp2, dp1 - prices[i])// the second time buy stock
        dp3 = max(dp3, dp2 + prices[i])// the second time sell stock
     */

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int dp0 = -prices[0], dp1 = Integer.MIN_VALUE, dp2 = Integer.MIN_VALUE, dp3 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            dp0 = Math.max(dp0, -prices[i]);
            dp1 = Math.max(dp1, dp0 + prices[i]);
            if (dp1 > Integer.MIN_VALUE) dp2 = Math.max(dp2, dp1 - prices[i]);
            if (dp2 > Integer.MIN_VALUE) dp3 = Math.max(dp3, dp2 + prices[i]);
        }
        return Math.max(0, Math.max(dp1, dp3));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}