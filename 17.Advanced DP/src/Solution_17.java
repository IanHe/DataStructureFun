public class Solution_17 {
    public static void main(String[] args) {
        Solution_17 solution = new Solution_17();
    }

    /*
        Two-dimensional DP
        along X: initialize dp[i][0] = i (i= length of word 1), along Y initialize dp[0][j] = j (j = length of word 2)
        if(X(i) == Y(i)) => dp[i][i] = Min(dp[i-1][i] + 1, dp[i][i-1] + 1, dp[i-1][i-1])
        else => dp[i][i] = Min(dp[i-1][i] + 1, dp[i][i-1] + 1, dp[i-1][i-1] + 1)
     */
    public int minDistance(String word1, String word2) {
        int x = word1.length(), y = word2.length();
        if (x * y == 0) return x + y; // if word1 or word2 is empty
        int[][] dp = new int[x + 1][y + 1];

        //initialize boundaries
        for (int i = 0; i < x + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < y + 1; j++) {
            dp[0][j] = j;
        }

        for(int i=1;i<x+1;i++){
            for(int j=1;j<y+1;j++){
                int left = dp[i-1][j] + 1;
                int down = dp[i][j-1] + 1;
                int leftDown = dp[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1)) leftDown +=1;
                dp[i][j] = Math.min(leftDown, Math.min(left, down));
            }
        }

        return dp[x][y];
    }
}
