##剑指 offer 23：链表中环的入口节点 - Medium - https://blog.csdn.net/weixin_37672169/article/details/80167240
###same as: https://leetcode.com/problems/linked-list-cycle-ii/
###Solution - Fast_Slow Pointers - TC: O(N), SC: O(1)
###https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
```
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return null;
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null; // no loop, return null
            fast = fast.next.next;
            slow = slow.next;
            if (fast == head) break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
```