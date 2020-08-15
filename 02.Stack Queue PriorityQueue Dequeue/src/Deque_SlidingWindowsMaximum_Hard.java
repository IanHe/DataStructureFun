import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Difficulty: Hard
 * Name: Sliding Windows
 * Link: https://leetcode-cn.com/problems/sliding-window-maximum/ or https://leetcode.com/problems/sliding-window-maximum/
 */
public class Deque_SlidingWindowsMaximum_Hard {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    /**
     * 1. Approach: Monotone Queue(or Dequeue)
     * 2. Time Complexity: O(N) - 每个元素被处理两次- 其索引被添加到双向队列中和被双向队列删除。
     * 3. Space ComplexityL O(N) - 输出数组使用了 O(N−k+1)空间，双向队列使用了 O(k)。
     * 示例
     * <p>
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * <p>
     * 解释过程中队列中都是具体的值，方便理解，具体见代码。
     * 初始状态：L=R=0,队列:{}
     * i=0,nums[0]=1。队列为空,直接加入。队列：{1}
     * i=1,nums[1]=3。队尾值为1，3>1，弹出队尾值，加入3。队列：{3}
     * i=2,nums[2]=-1。队尾值为3，-1<3，直接加入。队列：{3,-1}。此时窗口已经形成，L=0,R=2，result=[3]
     * i=3,nums[3]=-3。队尾值为-1，-3<-1，直接加入。队列：{3,-1,-3}。队首3对应的下标为1，L=1,R=3，有效。result=[3,3]
     * i=4,nums[4]=5。队尾值为-3，5>-3，依次弹出后加入。队列：{5}。此时L=2,R=4，有效。result=[3,3,5]
     * i=5,nums[5]=3。队尾值为5，3<5，直接加入。队列：{5,3}。此时L=3,R=5，有效。result=[3,3,5,5]
     * i=6,nums[6]=6。队尾值为3，6>3，依次弹出后加入。队列：{6}。此时L=4,R=6，有效。result=[3,3,5,5,6]
     * i=7,nums[7]=7。队尾值为6，7>6，弹出队尾值后加入。队列：{7}。此时L=5,R=7，有效。result=[3,3,5,5,6,7]
     * <p>
     * 通过示例发现R=i，L=k-R。由于队列中的值是从大到小排序的，所以每次窗口变动时，只需要判断队首的值是否还在窗口中就行了。
     * 解释一下为什么队列中要存放数组下标的值而不是直接存储数值，因为要判断队首的值是否在窗口范围内，由数组下标取值很方便，而由值取数组下标不是很方便。
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] output = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // deque stores the the index of array
            // remove smaller numbers in k range as they are useless, keep order from greater to smaller
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            // remove numbers out of range k
            // e.g: if deque.peek() is index 1, window is from 2 to 4, then index 1 should be removed
            if(deque.peek() <= i-k){
                deque.poll();
            }
            // when a sliding window forms
            if (i + 1 >= k) {
                output[i - k + 1] = nums[deque.peek()];
            }
        }
        return output;
    }

    /**
     * 1. Approach: Brute Force
     * 2. Time Complexity: O(Nk), Space Complexity: O(N-k+1)
     */
    public static int[] maxSlidingWindow_1(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }
}
