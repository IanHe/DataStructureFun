public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmpMin = Math.min(Math.min(max * nums[i], min * nums[i]), nums[i]);
            int tmpMax = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = tmpMin;
            max = tmpMax;
            result = Math.max(result, max);
        }
        return result;
    }
}
