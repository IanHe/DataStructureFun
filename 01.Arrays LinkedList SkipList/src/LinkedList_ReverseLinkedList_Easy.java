/**
 * Difficulty: Easy
 * Name: Reverse Linked List
 * Link: https://leetcode-cn.com/problems/reverse-linked-list/or https://leetcode.com/problems/reverse-linked-list/
 */
public class LinkedList_ReverseLinkedList_Easy {
  public static void main(String[] args) {
    ListNode head = ListNode.prepareData(6);
//    ListNode.printNodes(reverseList(node1));
    ListNode.printNodes(reverseList_recursive(head));
  }

  /**
   * 1. Approach: Two Pointers loop through the list
   * 2. Time Complexity: O(N), Space Complexity: O(1)
   */
  public static ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode tmp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = tmp;
    }
    return pre;
  }

  /**
   * 1. Approach: Recursion
   * 2. Time Complexity: O(N), Space Complexity: O(1)
   */
  public static ListNode reverseList_recursive(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    //base on the above condition, the 'cur' is the last node
    //for node list: 1->2->3->4->5，then the cur is 5
    ListNode cur = reverseList(head.next);
    //reverse the link between head and head.next
    head.next.next = head;
    head.next = null;
    return cur;
  }

}


