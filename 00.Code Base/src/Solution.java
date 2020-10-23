import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Deque deque = new LinkedList<>();
    }

    /*
        DP function:
        if(word1[i] == word2[j]) dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1] -1)
        else dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
        dp[0][0] = 0, dp[1][0] = 1, dp[2][0] = 2, ...
                      dp[0][1] = 1, dp[0][2] = 2, ...
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0) dp[0][j] = j;
                if (j == 0) dp[i][0] = i;
                if (i > 0 && j > 0) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1] - 1);
                    } else {
                        dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                    }
                }
            }
        }

        return dp[len1][len2];
    }

    private int min(int x, int y, int z) {
        return Math.min(z, Math.min(x, y));
    }


}
