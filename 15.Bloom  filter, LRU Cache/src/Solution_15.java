import java.util.HashMap;
import java.util.Map;

public class Solution_15 {
    public static void main(String[] args) {

    }


}

class LRUCache {
    private Map<Integer, LinkNode> cache = new HashMap<>();
    private int size, capacity;
    private LinkNode head, tail;
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //false head, tail
        head = new LinkNode();
        tail = new LinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkNode node = cache.get(key);
        if (node == null) return -1;
        //because node is being searched, move the node to head
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        LinkNode node = cache.get(key);
        if(node == null){
            LinkNode newNode = new LinkNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if(size > capacity){
                LinkNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(LinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(LinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(LinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private LinkNode removeTail() {
        //tails if false node, so the real tail the tail.prev
        LinkNode res = tail.prev;
        removeNode(res);
        return res;
    }

    class LinkNode {
        int key;
        int value;
        LinkNode prev, next;

        public LinkNode() {
        }

        public LinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
