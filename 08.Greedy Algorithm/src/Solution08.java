public class Solution08 {
    public static void main(String[] args) {
        Solution08 solution = new Solution08();
        System.out.println(solution.jump(new int[]{0}));
    }

    public int jump(int[] nums) {
        int rightBound = 0;
        int maxPos = 0;
        int steps = 0;
        // i can only reach nums.length - 2
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            //when encounter rightBound, then update rightBound using maxPos, increase steps
            if (i == rightBound) {
                rightBound = maxPos;
                steps++;
            }
        }
        return steps;
    }
}
