public class Solution_07 {
    public static void main(String[] args) {
        Solution_07 solution = new Solution_07();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(solution.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;
        int num = 0;
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < column; y++) {
                if (grid[x][y] == '1') {
                    num++;
                    dfs(grid, x, y);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int x, int y) {
        int row = grid.length;
        int column = grid[0].length;

        // terminator
        if (x < 0 || y < 0 || x >= row || y >= column || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';
        // dfs to children
        dfs(grid, x - 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
    }

}
