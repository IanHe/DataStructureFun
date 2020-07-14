import java.util.Arrays;

/**
 * Difficulty: Easy
 * Name: Move Zeroes
 * Link: https://leetcode-cn.com/problems/move-zeroes/ or https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeros_Easy {
    public static void main(String[] args) {
//        moveZeros_1(new int[]{1, 0, 3, 0, 12});
        moveZeros_2(new int[]{1, 0, 3, 0, 12});
    }

    /**
     * 1. shift non-zero values in the order from the start of the array
     * 2. fill remaining with zeros
     * 3. Time Complexity: O(n)
     * 4. Space Complexity: O(1)
     */
    public static void moveZeros_1(int[] nums) {

        if (nums == null) return;
        int pos = 0;
        for (int num : nums) {
            if (num != 0) nums[pos++] = num;
        }
        while (pos < nums.length) {
            nums[pos++] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * simplified with one iteration
     */
    public static void moveZeros_2(int[] nums) {
        if (nums == null) return;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (pos != i) {
                    nums[pos] = nums[i];
                    nums[i] = 0;
                }
                pos++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}

