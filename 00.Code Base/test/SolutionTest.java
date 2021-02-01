import org.testng.annotations.Test;

import org.testng.Assert;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();
        System.out.println(1 << 1);
        int result = sol.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        Assert.assertEquals(result, 0);
    }
}

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        //find the min when left == right
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[right]) { //the minimum on the right
                left = mid + 1;
            } else { // the minimum on the left including mid
                right = mid;
            }
        }
        return nums[left];
    }
}