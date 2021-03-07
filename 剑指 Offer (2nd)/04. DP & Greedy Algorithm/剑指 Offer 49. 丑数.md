##剑指 Offer 49. 丑数 - Medium - https://leetcode-cn.com/problems/chou-shu-lcof/
###same as: https://leetcode.com/problems/ugly-number-ii/
![img of offer 49](imgs/offer%2049.png)
###Solution - DP - TC: O(N), SC: O(N)
```
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
```