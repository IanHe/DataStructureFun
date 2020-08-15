public class Solution_08 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int canReachable = nums.length - 1; // canReachable mark the index of the element which can reach to the end
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= (canReachable - i)) {
                canReachable = i;
            }
        }
        return canReachable == 0;
    }
}
