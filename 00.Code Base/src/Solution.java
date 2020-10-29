public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class MyCircularDeque {
        int capacity;
        int size;
        Node head, tail;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            this.capacity = k;
            this.size = 0;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (this.isFull()) return false;
            Node node = new Node(value);
            if (size == 0) {
                this.head = node;
                this.tail = node;
            } else {
                this.head.prev = node;
                node.next = this.head;
                this.head = node;
            }
            this.size++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (this.isFull()) return false;
            Node node = new Node(value);
            if (size == 0) {
                this.head = node;
                this.tail = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
                this.tail = node;
            }
            this.size++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (this.isEmpty()) return false;
            if(size == 1) {
                this.head = null;
                this.tail = null;
            }else{
                Node newHead = this.head.next;
                newHead.prev = null;
                this.head = newHead;
            }
            size--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (this.isEmpty()) return false;
            if(size == 1) {
                this.head = null;
                this.tail = null;
            }else{
                Node newTail = this.tail.prev;
                newTail.next = null;
                this.tail = newTail;
            }
            size--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (this.isEmpty()) return -1;
            return this.head.val;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (this.isEmpty()) return -1;
            return this.tail.val;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return this.size == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return this.size == this.capacity;
        }

        class Node {
            int val;
            Node prev = null, next = null;

            Node(int val) {
                this.val = val;
            }
        }
    }
}