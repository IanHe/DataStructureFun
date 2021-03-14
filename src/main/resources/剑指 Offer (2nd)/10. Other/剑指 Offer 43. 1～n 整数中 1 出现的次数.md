##剑指 Offer 43. 1～n 整数中 1 出现的次数 - Hard - https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
###same as: https://leetcode.com/problems/number-of-digit-one/
![imgs of offer 43](imgs/offer%2043.png)
###Solution - Find Regularity - TC: O(log10 N), SC: O(1)
###https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
```
    /*
        digit is the bit of the number, starting from 1
        e.g: for 2039, digit in (1, 4)
        The regularity:
        cur == 0 => height * digit
        cur == 1 => high * digit + low + 1
        cur == 2,3..9 => (high + 1) * digit
     */
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            // move up digit
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
```
![imgs of offer 43_1](imgs/offer%2043_1.png)