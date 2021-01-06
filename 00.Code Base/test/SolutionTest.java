import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

import static org.testng.Assert.*;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();
//        assertEquals(sol.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}), 6);
    }
}

class Solution {
    /*
        if( s(i) == ')' ) =>
           if( s(i-1) == '(' ) => dp[i] = dp[i]=dp[i−2]+2
           else if( s[i−dp[i−1]−1]='(' ) => dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
     */
    public int longestValidParentheses(String s) {
        int len = 0;
        char[] chs = s.toCharArray();
        int[] dp = new int[chs.length];
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] == ')') {
                if (chs[i - 1] == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && chs[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
                len = Math.max(len, dp[i]);
            }
        }
        return len;
    }

}



