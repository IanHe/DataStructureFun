import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{0, 1}, {1, 0}};
    }

    public int slidingPuzzle(int[][] board) {
        int[][] dir = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

        String target = "123456";
        String start = boardToStr(board);

        Set<String> visited = new HashSet<>();
        Deque<String> deque = new LinkedList<>();
        deque.addLast(start);
        visited.add(start);
        int step = 1;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String str = deque.pollFirst();
                if (target.equals(str)) return step;
                int pos = str.indexOf('0');
                int[] nextMoves = dir[pos];
                for (int nextPos : nextMoves) {
                    String newStr = switchChar(str, pos, nextPos);
                    if (!visited.contains(newStr)) {
                        visited.add(newStr);
                        deque.addLast(newStr);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String switchChar(String str, int pos1, int pos2) {
        char[] chs = str.toCharArray();
        char tmp = chs[pos1];
        chs[pos1] = chs[pos2];
        chs[pos2] = tmp;
        return String.valueOf(chs);
    }

    private String boardToStr(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(board[i / 3][i % 3]);
        }
        return sb.toString();
    }
}
