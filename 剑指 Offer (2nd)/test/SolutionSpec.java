import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;


public class SolutionSpec {
    @Test
    public void testSolution() {
        Sol sol = new Sol();
        System.out.println(sol.climbStairs(5));
    }
}


class Sol {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next, pre = null;
        while (head != null && head.next != null) {
            // switch 2
            ListNode next = head.next;
            head.next = next.next;
            next.next = head;
            // move window
            if(pre != null) pre.next = next;
            pre = head;
            head = head.next;
        }
        return newHead;
    }

    public class ListNode {
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
//896
}
