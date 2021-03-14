##剑指 Offer 50. 第一个只出现一次的字符 - Easy - https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
![img of offer 50](imgs/offer%2050.png)
###Solution - Hash Table or Array - TC: O(N), SC: O(26) => O(1)
```
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc)
            dic.put(c, !dic.containsKey(c));
        for (char c : sc)
            if (dic.get(c)) return c;
        return ' ';
    }
    
    or Array(faster) - HashMap uses an array underneath plus hash function so it can never be faster than using an array correctly.:
    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        int[] counter = new int[26];
        char[] sc = s.toCharArray();
        for (char c : sc) {
            counter[c - 'a']++;
        }
        for (char c : sc) {
            if (counter[c - 'a'] == 1) return c;
        }
        return ' ';
    }
```