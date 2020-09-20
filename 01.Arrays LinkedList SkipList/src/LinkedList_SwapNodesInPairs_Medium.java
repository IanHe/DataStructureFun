///**
// * Difficulty: Medium
// * Name: Reverse Linked List
// * Link: https://leetcode-cn.com/problems/swap-nodes-in-pairs/ or https://leetcode.com/problems/swap-nodes-in-pairs/
// */
//public class LinkedList_SwapNodesInPairs_Medium {
//    public static void main(String[] args) {
//        ListNode head = ListNode.prepareData(4);
////        ListNode.printNodes(head);
////        ListNode.printNodes(swapPairs(head));
//        ListNode.printNodes(swapPairs_1(head));
//    }
//
//    /**
//     * 1. Approach: Iteration
//     * 2. Time Complexity: O(N), Space Complexity: O(1)
//     */
//    public static ListNode swapPairs(ListNode head) {
//        ListNode pre = new ListNode(0);
//        pre.next = head;
//        ListNode temp = pre;
//        while (temp.next != null && temp.next.next != null) {
//            ListNode start = temp.next;
//            ListNode end = temp.next.next;
//            temp.next = end;
//            start.next = end.next;
//            end.next = start;
//            temp = start;
//        }
//        return pre.next;
//    }
//
//    /**
//     * 1. Approach: Recursion
//     * 2. Time Complexity: O(N), Space Complexity: O(N)
//     */
//    public static ListNode swapPairs_1(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode next = head.next;
//        head.next = swapPairs_1(next.next);
//        next.next = head;
//        return next;
//    }
//
//}
