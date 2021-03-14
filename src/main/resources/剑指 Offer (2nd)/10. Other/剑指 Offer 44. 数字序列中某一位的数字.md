##剑指 Offer 44. 数字序列中某一位的数字 - Medium - https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
###same as: https://leetcode.com/problems/nth-digit/
![img of offer 44](imgs/offer%2044.png)
###Solution - Find Regularity - TC: O(log10 N), SC: O(log10 N)
###https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/
```
    /*
        1. 确定 n 所在 数字 的 位数 ，记为 digit ；
        2. 确定 n 所在的 数字 ，记为 num ；
        3. 确定 n 是 num 中的哪一数位，并返回结果。
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
```