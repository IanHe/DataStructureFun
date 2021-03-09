##剑指 Offer 56 - II. 数组中数字出现的次数 II - Medium - https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
![img of offer 56_II](imgs/offer%2056_II.png)
###Solution - Bit Operation - TC: O(N), SC: O(1)
###https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/
```
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
```