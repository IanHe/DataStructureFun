import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!linkedList.isEmpty() && nums[linkedList.peekLast()] <= nums[i]) linkedList.pollLast();
            linkedList.addLast(i);
            if (linkedList.peek() <= i - k ) linkedList.pollFirst();
            if (i >= k - 1) {
                result[i - k + 1] = nums[linkedList.peek()];
            }
        }
        return result;
    }
}