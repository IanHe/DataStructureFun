//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Difficulty: Easy
// * Name: Linked List Cycle
// * Link: https://leetcode-cn.com/problems/linked-list-cycle/ or https://leetcode.com/problems/linked-list-cycle/
// */
//public class LinkedList_LinkedListCycle_Easy {
//    public static void main(String[] args) {
//
//    }
//
//    /**
//     * 1. Approach: Two Pointers, the first pointer moves 1 step each time, the second moves 2 steps each time
//     * 2. Time Complexity: O(N), Space Complexity: O(1)
//     */
//    public static boolean hasCycle(ListNode head) {
//        if (head == null || head.next == null) return false;
//        ListNode slow = head;
//        ListNode fast = head.next;
//        while (fast != null && fast.next != null) {
//            if (slow.equals(fast)) {
//                return true;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return false;
//    }
//
//    /**
//     * 1. Approach: Two Pointers(Improved), slow pointer moves 1 step each time, fast pointer moves 2 steps each time
//     * 2. Time Complexity: O(N), Space Complexity: O(1)
//     */
//    public static boolean hasCycle_1(ListNode head) {
//        if (head == null || head.next == null) {
//            return false;
//        }
//        ListNode slow = head;
//        ListNode fast = head.next;
//        while (slow != fast) {
//            if (fast == null || fast.next == null) {
//                return false;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return true;
//    }
//
//    /**
//     * 1. Approach: Hash Table, duplicate -> Loop: true
//     * 2. Time Complexity: O(N), Space Complexity: O(N)
//     */
//    public static boolean hasCycle_2(ListNode head) {
//        Set<ListNode> set = new HashSet<>();
//        while (head != null) {
//            if (set.contains(head)) return true;
//            set.add(head);
//            head = head.next;
//        }
//        return false;
//    }
//
//
//}
