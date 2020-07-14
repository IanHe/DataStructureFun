/**
 * Difficulty: Medium
 * Name: Move Zeroes
 * Link: https://leetcode-cn.com/problems/container-with-most-water/ or https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater_Medium {
    public static void main(String[] args) {
//        System.out.println(maxArea_2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea_1(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * Two Pointer Approach
     * 1. Take two pointers, one at the beginning and one at the end of the array.
     * 2. Every time, move the pointer which is shorter than the other one towards the center with one step.
     * 3. Maintain a maxArea to store the maximum area obtained
     * 4. Time Complexity: O(n)
     * 5. Space Complexity: O(1)
     */
    public static int maxArea_1(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }

    /**
     * Brute Force Approach
     * 1. Two loops to calculate all areas, then find the biggest one
     * 2. Time complexity : O(n^2). Calculating area for all n(n-1)/2 height pairs.
     * 3. Space complexity : O(1). Constant extra space is used.
     */
    public static int maxArea_2(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    }
}
