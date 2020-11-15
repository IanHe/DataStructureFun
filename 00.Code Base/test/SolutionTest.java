import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        assertEquals(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}), 0);
        assertEquals(solution.findMin(new int[]{3, 4, 5, 1, 2}), 1);
        assertEquals(solution.findMin(new int[]{3}), 3);
    }
}

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}