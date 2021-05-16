import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
    }
}

class Solution {

    public int minKnightMoves(int x, int y) {
        int[][] DIRECTIONS = new int[][]{{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
        x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        boolean[][] visited = new boolean[305][305];
        visited[1][1] = true;

        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int curX = cur[0];
                int curY = cur[1];
                if (curX == x && curY == y) {
                    return result;
                }

                for (int[] d : DIRECTIONS) {
                    int newX = curX + d[0];
                    int newY = curY + d[1];
                    if (newX >= -1 && newY >= -1 && !visited[newX + 1][newY + 1]) {
                        queue.add(new int[]{newX, newY});
                        visited[newX + 1][newY + 1] = true;
                    }
                }
            }
            result++;
        }
        return -1;
    }
}

class TreeNode {
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