## 剑指 Offer 48. 最长不含重复字符的子字符串 - Medium - https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
### same as: https://leetcode.com/problems/longest-substring-without-repeating-characters/
![img of offer 48](imgs/offer%2048.png)
### Solution 1 - DP & Hashtable - TC: O(N), SC: O(1)

```
    /*
        哈希表统计： 遍历字符串 s 时，使用哈希表（记为 dic ）统计 各字符最后一次出现的索引位置。
        左边界 i 获取方式： 遍历到 s[j] 时，可通过访问哈希表 dic[s[j]] 获取最近的相同字符的索引 i。
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0; //tmp is the previous character's longest subString
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
```

![img of offer 48_1](imgs/offer%2048_1.png)