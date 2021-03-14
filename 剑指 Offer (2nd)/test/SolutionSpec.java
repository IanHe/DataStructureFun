import org.testng.annotations.Test;

import java.util.Arrays;


public class SolutionSpec {
    @Test
    public void testSolution() {
        Sol sol = new Sol();
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = sol.merge(arr);
        System.out.println(res);
    }
}


class Sol {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
        int[][] res = new int[intervals.length][2];
        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];
        int i = 0;
        for (int j = 1; j < intervals.length; j++) {
            int x = intervals[j][0], y = intervals[j][1];
            if(x <= res[i][1]){
                // merge
                res[i][1] = Math.max(res[i][1], y);
            }else{
                res[++i][0] = x;
                res[i][1] = y;
            }
        }
        return res;
    }
//896
}
