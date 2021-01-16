import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();
        System.out.println(1 << 1);
//        assertEquals(sol.myAtoi(" 123"), 123);

    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        int[][] mem = new int[s.length() + 1][p.length() + 1];
        return dfs(s.toCharArray(), 0, p.toCharArray(), 0, mem);
    }

    private boolean dfs(char[] s, int i, char[] p, int j, int[][] mem) {
        if (j >= p.length) return i >= s.length;
        if (mem[i][j] != 0) return mem[i][j] > 0;
        boolean match = i < s.length && ((s[i] == p[j]) || p[j] == '.');
        if (j < p.length - 1 && p[j + 1] == '*') {
            boolean t = dfs(s, i, p, j + 2, mem) || (match && dfs(s, i + 1, p, j, mem));
            if (t) mem[i][j] = 1;
            else mem[i][j] = -1;
            return t;
        }
        boolean t = match && dfs(s, i + 1, p, j + 1, mem);
        if (t) mem[i][j] = 1;
        else mem[i][j] = -1;
        return t;
    }
}



