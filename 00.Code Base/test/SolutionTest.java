import org.testng.annotations.Test;

import org.testng.Assert;

import java.util.*;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();
        System.out.println(1 << 2);
        System.out.println(5 & (~0 << 2)); // 5 => 101:  101 remove last 1s of 2
        System.out.println((5 >> 1) & 1); // 5 => 101, get the 3rd 1's number
        System.out.println(2 | (1 << 2));
        System.out.println(6 & (6 - 1));
        System.out.println(-10 >> 1);
        System.out.println(-10 >>> 1);
        System.out.println(3 & 1);
        System.out.println(2 & 1);
//        int result = sol.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
//        Assert.assertEquals(result, 6);
    }
}

class Solution {

}

class LRUCache {
    private Map<Integer, Node> cache = new HashMap<>();
    private int size, capacity;
    // create boundary node, boundaryLeft.next will be head node, boundaryRight.prev will be tail node
    // Sentinel design can help avoid null check
    private Node boundaryLeft, boundaryRight;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //false head, tail
        boundaryLeft = new Node();
        boundaryRight = new Node();
        boundaryLeft.next = boundaryRight;
        boundaryRight.prev = boundaryLeft;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        //because node is being searched, move the node to head
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                Node tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        node.prev = boundaryLeft;
        node.next = boundaryLeft.next;
        boundaryLeft.next.prev = node;
        boundaryLeft.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private Node removeTail() {
        //tails if false node, so the real tail the tail.prev
        Node res = boundaryRight.prev;
        removeNode(res);
        return res;
    }

    class Node {
        int key, value;
        Node prev, next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}