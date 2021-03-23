import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        System.out.println(-10 >> 1);
    }
}

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int rows = board.length;
        int cols = board[0].length;
        if (cols == 0) return;

        int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        UnionFind set = new UnionFind(rows * cols + 1);
        int src = rows * cols; // source node for node 'O' on board edges

        // union all 'O' nodes with its surrounding 'O' nodes
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X') continue;
                // 将边缘的'O'与超级源点src相连接
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    set.union(src, index(i, j, cols));
                } else {
                    // find surround 'O' node and union them
                    for (int k = 0; k < 4; k++) {
                        int x = i + direction[k][0];
                        int y = j + direction[k][1];
                        if (x >= 0 && y >= 0 && x < rows && y < cols && board[x][y] == 'O')
                            set.union(index(i, j, cols), index(x, y, cols));
                    }
                }
            }
        }

        // find 'O' parent node, excluding board edges
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (board[i][j] == 'O' && !set.isConnected(src, index(i, j, cols)))
                    board[i][j] = 'X';
            }
        }
    }

    private int index(int x, int y, int cols) {
        return x * cols + y;
    }

    static class UnionFind {
        private int[] parents;

        //init
        public UnionFind(int n) {
            this.parents = new int[n];
            for (int i = 0; i < n; i++) {
                // parent node are leading node => parent(a) = a
                parents[i] = i;
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int find(int x) {
            while (parents[x] != x) {
                // route compression
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            parents[rootX] = rootY;
        }
    }
}

