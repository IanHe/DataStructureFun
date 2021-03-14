##剑指 Offer 52. 两个链表的第一个公共节点 - Easy -https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/ 
###same as: https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
![img of offer 52](imgs/offer%2052.png)
###Solution - Two Pointer - TC: O(a + b - c), SC: O(1)
###a is the length of LinkedList A, b is the length of LinkedList B, c is the length of (LinkedList A & LinkedList B)
###if LinkedList A, B has no common node, then finally both pointers A, B will reach null
```
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }
```
![img of offer 52_1](imgs/offer%2052_1.png)