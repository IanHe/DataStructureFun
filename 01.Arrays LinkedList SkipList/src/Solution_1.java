public class Solution_1 {
    public static void main(String[] args) {
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] !=0){
                if(pointer != i){
                    nums[pointer] = nums[i];
                    nums[i] = 0;
                }
                pointer++;
            }
        }
    }
}




