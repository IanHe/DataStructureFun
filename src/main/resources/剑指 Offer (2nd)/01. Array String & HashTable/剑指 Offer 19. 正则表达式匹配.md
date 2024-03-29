##剑指 Offer 19. 正则表达式匹配 - Hard - https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
##same as: https://leetcode-cn.com/problems/regular-expression-matching/
![offer 19](imgs/offer 19.png)
```
    // DFS with memo: 1ms
    public boolean isMatch(String s, String p) {
        // length + 1, otherwise isMatch("ab", ".*") will throw out of index exception
        int[][] memo = new int[s.length() + 1][p.length() + 1];
        return dfs(s.toCharArray(), 0, p.toCharArray(), 0, memo);
    }

    private boolean dfs(char[] s, int i, char[] p, int j, int[][] memo) {
        if (j >= p.length) return i >= s.length; // check boundary, if p and s both reach boundary then return true
        if (memo[i][j] != 0) return memo[i][j] > 0;
        // if s[i] match p[j]
        boolean match = i < s.length && (s[i] == p[j] || p[j] == '.');
        // when p[j+1] == '*'
        if (j < p.length - 1 && p[j + 1] == '*') {
            // when don't match suppose '*' match 0 times then p skip to j+2
            // or p[j] and '*' matches, then s move to i+1
            boolean t = dfs(s, i, p, j + 2, memo) || (match && dfs(s, i + 1, p, j, memo));
            memo[i][j] = t ? 1 : -1;
            return t;
        }
        // when s[i] match p[j] && s[i+1] matches p[j+1]
        boolean t = match && dfs(s, i + 1, p, j + 1, memo);
        memo[i][j] = t ? 1 : -1;
        return t;
    }
```
![offer 19_1](imgs/offer 19_1.png)