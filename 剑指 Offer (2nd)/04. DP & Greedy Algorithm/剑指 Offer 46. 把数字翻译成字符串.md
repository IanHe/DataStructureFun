##剑指 Offer 46. 把数字翻译成字符串 - Medium - https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
![img of offer 46](imgs/offer%2046.png)
###Solution - DP - TC: O(N), SC: O(N)
###https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
```
    /*
        dp[0] = 1
        dp[1] = 1
        dp[i] = 10 < f(i-1, i) < 26 ? dp[i-1] + dp[i-2] : dp[i-1]
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int pre = 1, cur = 1;
        for (int i = 2; i <= str.length(); i++) {
            String sub = str.substring(i - 2, i);
            int c = (sub.compareTo("10") >= 0 && sub.compareTo("25") <= 0) ? pre + cur : cur;
            pre = cur;
            cur = c;
        }
        return cur;
    }
```
![img of offer 46_1](imgs/offer%2046_1.png)