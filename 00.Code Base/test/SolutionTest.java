import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();
        System.out.println(1 << 1);
//        assertEquals(sol.myAtoi(" 123"), 123);
        assertEquals(sol.removeDuplicates(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}), 6);
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        return removeDuplicates(nums, 2);
    }

    private int removeDuplicates(int[] nums, int k) {
        if (nums == null) return 0;
        if (nums.length < k) return nums.length;
        // because nums is sorted, if nums[i + k] == nums[i] which means nums[i + k] should be removed
        int len = nums.length;
        for (int i = 0; i + k < len; i++) {
            int count = 0;
            while (nums[i] == nums[i + k]) {
                nums[i + k] = nums[i + k + (++count)];
                len--;
            }
        }
        return len;
    }
}



