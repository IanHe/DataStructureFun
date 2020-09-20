public class Solution_1 {
    public static void main(String[] args) {
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        //round 1 - fast at speed 2, slow at 1
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        //round 2 - fast return to 0 and speed at 1
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}




