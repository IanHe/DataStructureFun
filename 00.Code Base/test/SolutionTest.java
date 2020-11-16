import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assertEquals(solution.coinChange(new int[]{1, 2, 5}, 11), 3);

    }
}

class Solution {
    /*
        dp[i] = min(dp[i-coin_1], dp[i-coin_2], ...dp[i-coin_n]) + 1
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return -1;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int coin : coins) {
                if (coin == i) {
                    dp[i] = 1;
                    break;
                }
                if (coin < i) dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
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