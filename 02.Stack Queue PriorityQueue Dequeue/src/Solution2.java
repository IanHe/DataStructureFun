public class Solution2 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));
    }

    public int trap(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int left = 0, right = height.length - 1;
        int result = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }else{
                    result += leftMax - height[left];
                }
                //move left pointer
                ++left;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }{
                    result += rightMax - height[right];
                }
                //move right pointer
                --right;
            }
        }
        return result;
    }

}