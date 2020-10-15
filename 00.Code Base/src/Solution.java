public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    public void solveSudoku(char[][] board) {

    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false; // check row
            if (board[i][col] == c) return false; // check col
            // check 3 * 3 block
            int x = 3 * (row / 3) + i / 3;
            int y = 3 * (col / 3) + i % 3;

        }
    }

}
