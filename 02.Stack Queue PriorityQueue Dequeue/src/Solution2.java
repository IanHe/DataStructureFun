import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution2 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));
    }

    public static int[] _maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        if (k == 1) return nums;

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] <=nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            while(deque.peekFirst() <= i-k){
                deque.pollFirst();
            }

            if(i+1 >= k){
                result[i+1 -k] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList<>();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }
}