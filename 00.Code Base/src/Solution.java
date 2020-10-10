public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) { //the minimum on the right
                left = mid + 1;
            } else { // the minimum on the left including mid
                right = mid;
            }
        }
        return nums[left];
    }
}
