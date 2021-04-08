import org.testng.annotations.Test;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        TicTacToe ticTacToe = new TicTacToe(2);
        ticTacToe.move(0, 1, 1);
        ticTacToe.move(1, 1, 2);
        ticTacToe.move(1, 0, 1);
    }
}

class Solution {
}

class TicTacToe {
    int[] row, col;
    int diagonal, antiDiagonal;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        row = new int[n];
        col = new int[n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int x, int y, int player) {
        int n = row.length;
        row[x] += player == 1 ? 1 : -1;
        if (Math.abs(row[x]) == n) return player;
        col[y] += player == 1 ? 1 : -1;
        if (Math.abs(col[y]) == n) return player;
        if (x == y) {
            diagonal += player == 1 ? 1 : -1;
            if (Math.abs(diagonal) == n) return player;
        }
        if (x + y == n - 1) {
            antiDiagonal += player == 1 ? 1 : -1;
            if (Math.abs(antiDiagonal) == n) return player;
        }
        return 0;
    }
}