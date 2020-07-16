/**
 * Difficulty: Easy
 * Name: Reverse Linked List
 * Link: https://leetcode-cn.com/problems/reverse-linked-list/or https://leetcode.com/problems/reverse-linked-list/
 */
public class LinkedList_ReverseLinkedList_Easy {
  public static void main(String[] args) {
    ListNode head = prepareData(6);
//    printNodes(reverseList(node1));
    printNodes(reverseList_recursive(head));
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

  //Definition for singly-linked list.
  private static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  private static void printNodes(ListNode head) {
    System.out.println();
    while (head.next != null) {
      System.out.print(head.val + ", ");
      head = head.next;
    }
    System.out.print(head.val);
  }

  private static ListNode prepareData(int size) {
    ListNode next = null;
    for (int i = size; i > 0; i--) {
      ListNode node = new ListNode(i);
      if(next !=null){
        node.next = next;
      }
      next = node;
    }
    return next;
//    ListNode node1 = new ListNode(1);
//    ListNode node2 = new ListNode(2);
//    ListNode node3 = new ListNode(3);
//    ListNode node4 = new ListNode(4);
//    ListNode node5 = new ListNode(5);
//    node1.next = node2;
//    node2.next = node3;
//    node3.next = node4;
//    node4.next = node5;
//    return node1
  }
}


