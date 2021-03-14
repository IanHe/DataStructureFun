##剑指 Offer 53 - II. 0～n-1中缺失的数字 - Easy - https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
![img of offer 53_II](imgs/offer%2053_II.png)
###Solution - Binary Search - TC: O(log N), SC: O(1)
###https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/
```
    //跳出时，变量 i 和 j 分别指向 “右子数组的首位元素” 和 “左子数组的末位元素” 。因此返回 i 即可。
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >> 1;
            if (nums[m] == m) i = m + 1; // missing number is on the right
            else j = m - 1; // missing number is on the left
        }
        return i;
    }
```