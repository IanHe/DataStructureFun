import org.testng.annotations.Test;

import org.testng.Assert;

import java.util.*;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();
        int result = sol.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 21, 18});
        Assert.assertEquals(result, 4);
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if (res == j) res++;
        }
        return res;
    }
}
