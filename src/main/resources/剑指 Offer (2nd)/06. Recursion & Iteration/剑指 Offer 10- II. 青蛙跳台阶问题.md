##剑指 Offer 10- II. 青蛙跳台阶问题 - easy - https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
```
    /*
        Iteration:
        the number need module 1000000007
        dp0 = , dp1 = 1, dp2 = 2
     */
    public int numWays(int n) {
        if (n == 0) return 1;
        if (n <= 2) return n;
        int pre = 1, cur = 2;
        for (int i = 3; i < n + 1; i++) {
            int tmp = cur;
            cur = (cur + pre) % 1000000007;
            pre = tmp;
        }
        return cur;
    }
    
    /*
        Tail Recursion
     */
    public int numWays(int n) {
        return tailDfs(n, 1, 1);
    }

    private int tailDfs(int n, int a, int b) {
        if (n <= 1) return b;
        return tailDfs(n - 1, b, a + b);
    }
```
![offer 10_2.png](imgs/offer%2010_2.png)