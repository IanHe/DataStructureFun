import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public int[] twoSum(int[] nums, int target) {
        // store nums[i] -> i
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                return new int[]{i, map.get(value)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}