import java.util.Arrays;

public class Solution_16 {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        // sort array, let it be like [[0,2], [0, 1], [1, 2], [1, 3], ...[99, 100] ]
        Arrays.sort(intervals, (arr1, arr2) -> (arr1[0] - arr2[0]));
        //result
        int[][] result = new int[intervals.length][2];
        int i = -1;
        for (int[] interval : intervals) {
            // when index start or the next one's first element is greater than the current one's last element, add new item
            if (i == -1 || result[i][1] < interval[0]) {
                result[++i] = interval;
            } else {
                // merge the next
                result[i][1] = Math.max(result[i][1], interval[1]);
            }
        }
        return Arrays.copyOf(result, i + 1);
    }
}


