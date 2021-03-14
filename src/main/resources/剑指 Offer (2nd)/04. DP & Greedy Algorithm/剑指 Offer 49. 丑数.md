##剑指 Offer 49. 丑数 - Medium - https://leetcode-cn.com/problems/chou-shu-lcof/
###same as: https://leetcode.com/problems/ugly-number-ii/
![img of offer 49](imgs/offer%2049.png)
###Solution - DP - TC: O(N), SC: O(N)
```
    public int nthUglyNumber(int n) {
        int i2 = 0, i3 = 0, i5 = 0; // index for ugly number: 2, 3, 5, starting index: 0
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[i2] * 2, n3 = dp[i3] * 3, n5 = dp[i5] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) i2++;
            if (dp[i] == n3) i3++;
            if (dp[i] == n5) i5++;
        }
        return dp[n - 1];
    }
```
![img of offer 49_1](imgs/offer%2049_1.png)