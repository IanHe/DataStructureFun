##剑指 Offer 47. 礼物的最大价值 - Medium - https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
![img of offer 47](imgs/offer%2047.png)
###Solution - DP - TC: O(M*N), SC: O(N) - M is the num of rows, N is the num of columns
###https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/solution/mian-shi-ti-47-li-wu-de-zui-da-jie-zhi-dong-tai-gu/
```
    /*
        dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + f(i, j)
     */
    public int maxValue(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0) {
                    dp[j] = j > 0 ? dp[j - 1] + grid[i][j] : grid[i][j];
                } else {
                    dp[j] = j == 0 ? dp[j] + grid[i][j] : Math.max(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[dp.length - 1];
    }
```
![img of offer 47_1](imgs/offer%2047_1.png)