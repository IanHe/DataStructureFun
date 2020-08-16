public class Solution_09 {
    public static void main(String[] args) {
        Solution_09 solution = new Solution_09();
        long startTime = System.currentTimeMillis();
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {}, {23, 30, 34, 50}};
        System.out.println(solution.searchMatrix(matrix, 11));
        System.out.println(System.currentTimeMillis() - startTime);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length==0) return false;
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int[] midArray = matrix[mid];
            if (midArray[0] > target) {
                right = mid - 1;
            } else if (midArray[midArray.length - 1] < target) {
                left = mid + 1;
            } else {
                return searchArray(midArray, target);
            }
        }
        return false;
    }

    private boolean searchArray(int[] array, int target) {
        if (array == null || array.length == 0) return false;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
