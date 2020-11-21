import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();

    }
}

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        UnionFind uf = new UnionFind(m * n + 1);
        int edgeIndex = m * n;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1)
                        uf.union(edgeIndex, index(i, j, n));
                    else {
                        for (int[] dir : dirs) {
                            int x = i + dir[0], y = j + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O')
                                uf.union(index(i, j, n), index(x, y, n));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !uf.isConnected(index(i, j, n), edgeIndex))
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


