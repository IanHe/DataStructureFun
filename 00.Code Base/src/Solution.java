import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1,2,3,1}));
    }



    public int rob(int[] nums){
        if(nums==null || nums.length==0) return 0;
        if(nums.length == 1) return nums[0];
        int rob1 = _rob(Arrays.copyOfRange(nums, 0, nums.length-1));
        int rob2 = _rob(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(rob1, rob2);
    }

    // when houses are lined in a line
    private int _rob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
