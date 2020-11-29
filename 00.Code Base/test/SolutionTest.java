import org.testng.annotations.Test;

import java.util.*;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
    }
}

class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] dir = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        String target = "123450";
        Node cur = new Node(board);
        if (cur.boardStr.equals(target)) return 0;

        PriorityQueue<Node> queue = new PriorityQueue<>( (a, b) -> a.power - b.power);
        queue.offer(cur);
        HashSet<Node> visited = new HashSet<>();
        visited.add(cur);

        while (!queue.isEmpty()) {
            cur = queue.poll();
            for (int nextZeroPos : dir[cur.zeroPos]) {
                String nextStr = swap(cur.boardStr, cur.zeroPos, nextZeroPos);
                if (nextStr.equals(target)) return cur.count + 1;
                Node next = new Node(nextStr, nextZeroPos, cur.count + 1);
                if (visited.contains(next)) continue;
                queue.offer(next);
                visited.add(next);
            }
        }
        return -1;
    }

    private String swap(String str, int posA, int posB) {
        char[] arr = str.toCharArray();
        char tmp = arr[posA];
        arr[posA] = arr[posB];
        arr[posB] = tmp;
        return String.valueOf(arr);
    }

    private String boardString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(board[i / 3][i % 3]);
        }
        return sb.toString();
    }

    class Node {
        String boardStr;
        int zeroPos;
        int count; // g(n)
        int distance; // h(n)
        int power; // f(n) = g(n) + h(n) - priority power

        public Node(int[][] board) {
            //change board to one-dimensional array
            this.boardStr = boardString(board);
            this.count = 0;
            this.distance = calcDistance();
            this.power = this.count + this.distance;
            this.zeroPos = this.boardStr.indexOf('0');
        }

        public Node(String boardStr, int zeroPos, int count) {
            this.boardStr = boardStr;
            this.zeroPos = zeroPos;
            this.count = count;
            this.distance = calcDistance();
            this.power = this.count + this.distance;
        }

        private int calcDistance() {
            int distance = 0;
            char[] chars = boardStr.toCharArray();
            for (int i = 0; i < 6; i++) {
                int v = chars[i] - 1;
                // 曼哈顿距离，计算每个坐标的当前位置与最终位置的距离
                distance += Math.abs(v / 3 - i / 3) + Math.abs(v % 3 - i % 3);
            }
            return distance;
        }
    }
}


