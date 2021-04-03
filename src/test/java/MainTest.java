import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        Solution.Node head = new Solution.Node(3);
        head.next = new Solution.Node()
    }
}

class Solution {

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        Node dummy = new Node(10001), node1 = head, node2 = dummy;
        while(node1 != null) {
            node2.next = new Node(node1.val);
            map.put(node1.val, node2.next);
            node1 = node1.next;
            node2 = node2.next;
        }
        node1 = head;
        node2 = dummy.next;
        while(node1 != null) {
            if(node1.random != null) {
                node2.random = map.get(node1.random.val);
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return dummy.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}