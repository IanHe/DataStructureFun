import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        System.out.println(sol.jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}));
    }
}

class Solution {
    public int jump(int[] nums) {
        if (nums[0] == 0 || nums.length == 1) return 0;
        int maxReach = nums[0], rightBound = nums[0];
        int jump = 1;
        for (int i = 1; i < nums.length - 1 && i <= maxReach && maxReach < nums.length - 1; i++) {
            if (i + nums[i] > maxReach) {
                maxReach = i + nums[i];
            }
            if (i == rightBound) {
                rightBound = maxReach;
                jump++;
            }
        }
        return jump;
    }
}
