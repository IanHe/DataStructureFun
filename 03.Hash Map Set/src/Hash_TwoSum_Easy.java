import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Difficulty: Easy
 * Name: Two Sum
 * Link: https://leetcode-cn.com/problems/2sum/ or https://leetcode.com/problems/two-sum/
 */
public class Hash_TwoSum_Easy {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    }

    /**
     * 1. Approach: Using Hash - Improved
     * 2. Time Complexity: O(N), Space Complexity: O(N)
     */
    public static int[] twoSum(int[] nums, int target) {
        // store value -> index
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

    /**
     * 1. Approach: Using Hash
     * 2. Time Complexity: O(N), Space Complexity: O(N)
     */
    public static int[] twoSum_(int[] nums, int target) {
        // store value -> index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            Integer key = map.get(value);
            if (key != null && key != i) {
                return new int[]{i, key};
            }
        }
        return new int[]{};
    }


}
