import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }


}

class LRUCache {
    private Map<Integer, Node> cache = new HashMap<>();
    private int size, capacity;

    private Node leftBound, rightBound;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.leftBound = new Node();
        this.rightBound = new Node();
        this.leftBound.next = rightBound;
        this.rightBound.prev = this.leftBound;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
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
        node.prev = this.leftBound;
        node.next = this.leftBound.next;
        this.leftBound.next = node;
        node.next.prev = node;
    }

    private Node removeTail() {
        Node res = this.rightBound.prev;
        removeNode(res);
        return res;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
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
