import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n > 0) backtrack(new int[n][n], res, 0);
        return res;
    }

    private void backtrack(int[][] board, List<List<String>> res, int row) {
        //terminator
        if (row == board.length) {
            res.add(boardToList(board));
            return;
        }
        //traverse each row
        for (int i = 0; i < board.length; i++) {
            if (valid(board, row, i)) {
                board[row][i] = 1;
                backtrack(board, res, row + 1);
                board[row][i] = 0;
            }
        }
    }

    private List<String> boardToList(int[][] board) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int cell : board[i]) {
                if (cell == 1) sb.append("Q");
                else sb.append(".");
            }
            path.add(sb.toString());
        }
        return path;
    }

    private boolean valid(int[][] board, int row, int col) {
        //check perpendicular
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }
        //check upper right
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) return false;
        }
        //check upper left
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }
}