import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assertEquals(solution.uniquePaths(3, 7), 28);
        assertEquals(solution.uniquePaths(3, 2), 3);
        assertEquals(solution.uniquePaths(7, 3), 28);
        assertEquals(solution.uniquePaths(1, 1), 1);
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(m - 1, n - 1, new int[m][n]);
    }

    private int dfs(int m, int n, int[][] memo) {
        if (m < 0 || n < 0) return 0;
        if (m == 0 || n == 0) return 1;
        if (memo[m][n] == 0) {
            memo[m][n] = dfs(m - 1, n, memo) + dfs(m, n - 1, memo);
        }
        return memo[m][n];
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