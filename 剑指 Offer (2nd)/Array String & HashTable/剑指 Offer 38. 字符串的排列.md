##剑指 Offer 38. 字符串的排列 - Medium - https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
![img of offer_38](imgs/offer%2038.png)
###Solution 1 - DFS & Prune - TC: O(N !N), SC: O(N^2)
###https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/
```
    public String[] permutation(String s) {
        List<String> res = new LinkedList<>();
        char[] c = s.toCharArray();
        dfs(0, c, res);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x, char[] c, List<String> res) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue; // 重复，因此剪枝 - Prune
            set.add(c[i]);
            swap(i, x, c);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1, c, res);              // 开启固定第 x + 1 位字符
            swap(i, x, c);                      // 恢复交换 - set back state
        }
    }

    void swap(int a, int b, char[] c) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
```