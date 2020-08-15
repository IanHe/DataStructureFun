import java.util.Stack;

/**
 * Difficulty: Hard
 * Name: Largest Rectangle in Histogram
 * Link: https://leetcode-cn.com/problems/largest-rectangle-in-histogram or https://leetcode.com/problems/largest-rectangle-in-histogram
 */
public class Stack_LargestRectangleInHistogram_Hard {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea(new int[]{1}));
        System.out.println(largestRectangleArea(new int[]{1, 2}));
        System.out.println(largestRectangleArea(new int[]{2, 1, 2}));
        System.out.println(largestRectangleArea(new int[]{}));
        System.out.println(largestRectangleArea(null));
    }

    /**
     * 1. Approach:  Monotonous stack
     * 2. Time Complexity: O(N), Space Complexity: O(N)
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1) return 0;
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                // should pop out first, then stack.peek() would be the left boundary
                int curIndex = stack.pop();
                // i is right boundary and stack.peek() is current item's left boundary
                area = Math.max(area, (i - (stack.peek() + 1)) * newHeights[curIndex]);
            }
            stack.push(i);
        }
        return area;
    }
}
