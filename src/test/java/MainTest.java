import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        int[][] buildings = {{1,2,1},{2147483646,2147483647,2147483647}};
        List<List<Integer>> res = sol.getSkyline(buildings);
        System.out.println(res);
    }
}

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings.length == 0) return new ArrayList<>();
        return merge(buildings, 0, buildings.length - 1);
    }

    private List<List<Integer>> merge(int[][] buildings, int start, int end) {
        List<List<Integer>> res = new ArrayList<>();
        // only 1 building, add [x, h], [y, 0] to the result
        // this will convert all merge blocks to be [[x, h1], [y, 0]]
        if (start == end) {
            res.add(new ArrayList<>() {{
                add(buildings[start][0]);
                add(buildings[start][2]);
            }});
            res.add(new ArrayList<>() {{
                add(buildings[start][1]);
                add(0);
            }});
            return res;
        }
        int mid = (start + end) >> 1;
        List<List<Integer>> leftSkyLine = merge(buildings, start, mid);
        List<List<Integer>> rightSkyLine = merge(buildings, mid + 1, end);

        // merge leftSkyLine and rightSkyLine
        int h1 = 0, h2 = 0;
        int i = 0, j = 0;
        while (i < leftSkyLine.size() || j < rightSkyLine.size()) {
            // long value for cases like: [[1,2,1],[2147483646,2147483647,2147483647]]
            long x;
            long x1 = (i < leftSkyLine.size()) ? leftSkyLine.get(i).get(0) : Long.MAX_VALUE;
            long x2 = (j < rightSkyLine.size()) ? rightSkyLine.get(j).get(0) : Long.MAX_VALUE;
            if (x1 < x2) {
                x = x1;
                h1 = leftSkyLine.get(i).get(1);
                i++;
            } else if (x1 > x2) {
                x = x2;
                h2 = rightSkyLine.get(j).get(1);
                j++;
            } else {
                h1 = leftSkyLine.get(i).get(1);
                h2 = rightSkyLine.get(j).get(1);
                x = x1;
                i++;
                j++;
            }
            int h = Math.max(h1, h2);
            // if height equals the previous height, skip duplicate height
            if (res.isEmpty() || h != res.get(res.size() - 1).get(1)) {
                res.add(new ArrayList<>() {{
                    add((int) x);
                    add(h);
                }});
            }
        }
        return res;
    }
}

