import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        System.out.println(sol.missingNumber(new int[]{3, 0, 1}));
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len + 1];
        for(int i = 0; i< len; i++) {
            if(nums[i] == i) {
                ans[i] = 1;
            }else if(nums[i] <= len && nums[i] >=0){
                ans[nums[i]] = 1;
            }
        }

        for (int i = 0; i < len + 1; i++) {
            if(ans[i] == 0) return i;
        }
        return -1;
    }
}