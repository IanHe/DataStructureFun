import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();
        System.out.println(1 << 1);
//        assertEquals(sol.myAtoi(" 123"), 123);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return list;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicate
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(List.of(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // skip left pointer duplicate
                    while (left < right && nums[right] == nums[right - 1]) right--; // slip right pointer duplicate
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }
}



