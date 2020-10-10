import java.util.ArrayDeque;
import java.util.Queue;

public class Solution07 {
    public static void main(String[] args) {
        Solution07 solution = new Solution07();
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(3);
        TreeNode node_3 = new TreeNode(2);
        TreeNode node_4 = new TreeNode(5);
        TreeNode node_5 = new TreeNode(3);
        TreeNode node_6 = new TreeNode(9);
    }

    public int _numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length, column = grid[0].length;
        int num = 0;
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < column; y++) {
                // when encounter '1', use dfs to set all surrounded '1' to be '0'
                if (grid[x][y] == '1') {
                    num++;
                    grid[x][y] = '0';
                    int pos = x * column + y;
                    Queue<Integer> queue = new ArrayDeque<>() {{
                        add(pos);
                    }};
                    while (!queue.isEmpty()) {
                        int _pos = queue.peek();
                        int posX = _pos / column;
                        int posY = _pos % column;
                        // loop 4 directions
                        if (posX - 1 >= 0 && grid[posX - 1][posY] == '1') {
                            queue.add((posX - 1) * column + posY);
                            grid[posX - 1][posY] = '0';
                        }
                        if (posX + 1 < row && grid[posX + 1][posY] == '1') {
                            queue.add((posX + 1) * column + posY);
                            grid[posX + 1][posY] = '0';
                        }
                        if (posY - 1 >= 0 && grid[posX][posY - 1] == '1') {
                            queue.add(posX * column + posY - 1);
                            grid[posX][posY - 1] = '0';
                        }
                        if (posY + 1 < column && grid[posX][posY + 1] == '1') {
                            queue.add(posX * column + posY + 1);
                            grid[posX][posY + 1] = '0';
                        }
                    }
                }
            }
        }
        return num;
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < column; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new ArrayDeque<>();
                    neighbors.add(r * column + c);
                    while (!neighbors.isEmpty()) {
                        int pos = neighbors.remove();
                        int posX = pos / column;
                        int posY = pos % column;
                        if (posX - 1 >= 0 && grid[posX-1][posY] == '1') {
                            neighbors.add((posX-1) * column + posY);
                            grid[posX-1][posY] = '0';
                        }
                        if (posX + 1 < row && grid[posX+1][posY] == '1') {
                            neighbors.add((posX+1) * column + posY);
                            grid[posX+1][posY] = '0';
                        }
                        if (posY - 1 >= 0 && grid[posX][posY-1] == '1') {
                            neighbors.add(posX * column + posY-1);
                            grid[posX][posY-1] = '0';
                        }
                        if (posY + 1 < column && grid[posX][posY+1] == '1') {
                            neighbors.add(posX * column + posY+1);
                            grid[posX][posY+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }




    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
