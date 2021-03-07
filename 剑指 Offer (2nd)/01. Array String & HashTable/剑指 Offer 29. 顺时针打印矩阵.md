##剑指 Offer 29. 顺时针打印矩阵 - Easy - https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
###same as: https://leetcode-cn.com/problems/spiral-matrix/
![offer 29](../09.%20Tree/imgs/offer%2029.png)
###Solution - TC: O(M * N), SC: O(1)
###https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
```
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        // boundaries: left, right, top, bottom
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int x = 0;
        int[] res = new int[(right + 1) * (bottom + 1)];
        while (true) {
            for (int i = left; i <= right; i++) res[x++] = matrix[top][i]; // left to right.
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) res[x++] = matrix[i][right]; // top to bottom.
            if (left > --right) break;
            for (int i = right; i >= left; i--) res[x++] = matrix[bottom][i]; // right to left.
            if (top > --bottom) break;
            for (int i = bottom; i >= top; i--) res[x++] = matrix[i][left]; // bottom to top.
            if (++left > right) break;
        }
        return res;
    }
```