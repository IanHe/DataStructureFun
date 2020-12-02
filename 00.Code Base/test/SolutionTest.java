import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SolutionTest {
    @Test
    public void testSolution() {
//        Solution solution = new Solution();
    }
}

class LRUCache {
    int size, capacity;
    Map<Integer, Node> cache;
    Node leftBound, rightBound;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.leftBound = new Node();
        this.rightBound = new Node();
        leftBound.next = rightBound;
        rightBound.prev = leftBound;
    }

    public int get(int key) {
        Node node = this.cache.get(key);
        if (node == null) return -1;
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            node = new Node(key, value);
            cache.put(key, node);
            addToHead(node);
            size++;
            if (size > capacity) removeTail();
        }
    }

    private void moveToHead(Node node) {
        remove(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        node.prev = leftBound;
        node.next = leftBound.next;
        leftBound.next.prev = node;
        leftBound.next = node;
    }

    private void remove(Node node) {
        if (node.prev != null) node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
    }

    private void removeTail() {
        Node tail = rightBound.prev;
        if (tail != null) {
            remove(tail);
            cache.remove(tail.key);
            size--;
        }
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


