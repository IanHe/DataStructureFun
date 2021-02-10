import org.testng.Assert;
import org.testng.annotations.Test;


public class SolutionSpec {

    @Test
    public void testSolution() {
        Sol sol = new Sol();
        int[] arr = new int[]{1, 3, 3};

//        Assert.assertEquals(sol.minArray(arr), 1);
    }
}


class Sol {

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, words, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] word, int k) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word[k])
            return false;
        if (k == word.length - 1) return true;
        board[i][j] = ' ';
        boolean res = dfs(board, i + 1, j, word, k + 1) || dfs(board, i, j + 1, word, k + 1)
                || dfs(board, i - 1, j, word, k + 1) || dfs(board, i, j - 1, word, k + 1);
        board[i][j] = word[k];
        return res;
    }

}

// Java program for implementation of QuickSort
class QuickSort {

}