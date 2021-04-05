import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        String s = sol.longestPalindrome("babad");
        System.out.println(s);
    }
}

class Solution {

    /*
        DP Function: dp[i][j] == true means S(i, j) is palindromic

        dp[i][i] = true     // single character is palindromic
        dp[i][i+1] = s.charAt(i) == s.charAt(i+1)
        // if dp[i][j] need to be true then dp[i+1][j-1] == true && s.charAt(i) == s.charAt(j)
        dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j)
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = {0, 0};
        for (int l = 0; l < n; ++l) { // l: length
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans[1] - ans[0]) { // if j - i + 1 > ans.length() -> replace ans; j - i is equal l
                    ans = new int[]{i, j};
                }
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}