import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();
        System.out.println(1 << 1);
        assertEquals(sol.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}), 6);
    }
}

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int n = height.length;
        int left = 0, right = n - 1; // two pointers
        int leftMax = 0, rightMax = 0, result = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            // min(i_leftMax, i_rightMax) is the matter
            // if leftMax < rightMax which means leftMax is the min(i_leftMax, i_rightMax) on the left pointer
            if (leftMax < rightMax) {
                result += leftMax - height[left]; // leftMax always >= left
                left++;
            } else {
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }
}



