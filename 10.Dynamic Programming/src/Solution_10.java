public class Solution_10 {
    public static void main(String[] args) {
        Solution_10 solution = new Solution_10();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] matrix = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //get chars c1, c2 from text1 and text2
                char c1 = text1.charAt(i), c2 = text2.charAt(j);
                if (c1 == c2) {
                    // when c1, c2, get the previous cell then plus 1
                    matrix[i + 1][j + 1] = matrix[i][j] + 1;
                } else {
                    // get the max cell from (left, above)
                    matrix[i + 1][j + 1] = Math.max(matrix[i + 1][j], matrix[i][j + 1]);
                }
            }
        }
        return matrix[m][n];
    }
}
