
/**
 * Difficulty: Medium
 * Name: Design Circular Deque
 * Link: https://leetcode-cn.com/problems/design-circular-deque/or https://leetcode.com/problems/design-circular-deque/
 */
public class Deque_DisigningCircularDequeue_Medium {
    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // set the size to be 3
        System.out.println(circularDeque.insertLast(1));            // return true
        System.out.println(circularDeque.insertLast(2));            // return true
        System.out.println(circularDeque.insertFront(3));            // return true
        System.out.println(circularDeque.insertFront(4));            // return false, the queue is full
        System.out.println(circularDeque.getRear());            // return 2
        System.out.println(circularDeque.isFull());                // return true
        System.out.println(circularDeque.deleteLast());            // return true
        System.out.println(circularDeque.insertFront(4));            // return true
        System.out.println(circularDeque.getFront());            // return 4
    }


}

/**
 * 1. Approach: self-defined LinkedList
 */
class MyCircularDeque {
    int count;
    int capacity;
    Node head, tail;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.count = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (count == capacity) {
            return false;
        }
        Node node = new Node(value);
        if (count == 0) {
            this.head = this.tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = head.prev;
        }
        count++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (count == capacity) {
            return false;
        }
        Node node = new Node(value);
        if (count == 0) {
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = this.tail.next;
        }
        count++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (count == 0) return false;
        if (count == 1) {
            this.head = this.tail = null;
        } else {
            Node tmp = this.head;
            this.head = tmp.next;
            this.head.prev = null;
            tmp.next = null;
        }
        count--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (count == 0) return false;
        if (count == 1) {
            this.head = this.tail = null;
        } else {
            Node tmp = this.tail;
            this.tail = tmp.prev;
            this.tail.next = null;
            tmp.prev = null;
        }
        count--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (count == 0) return -1;
        return this.head.val;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (count == 0) return -1;
        return this.tail.val;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return count == capacity;
    }

    class Node {
        int val;
        Node prev = null, next = null;

        Node(int val) {
            this.val = val;
        }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
