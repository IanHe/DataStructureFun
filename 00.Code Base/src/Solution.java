public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        solution.printNode(solution.swapPairs(node1));
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next, pre = null;
        while (head != null && head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = head;
            if(pre !=null) pre.next = next;
            pre = head;
            head = head.next;
        }
        return newHead;
    }

    private void printNode(ListNode head) {
        if (head == null) return;
        System.out.print(head.val + ", ");
        printNode(head.next);
    }


    static class ListNode {
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


}
