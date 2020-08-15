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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListNode)) return false;
        return this.val == ((ListNode) obj).val;
    }

    @Override
    public int hashCode() {
        return this.val * 1234;
    }

    public static ListNode prepareData(int size) {
        ListNode next = null;
        for (int i = size; i > 0; i--) {
            ListNode node = new ListNode(i);
            if (next != null) {
                node.next = next;
            }
            next = node;
        }
        return next;
    }

    public static void printNodes(ListNode head) {
        System.out.println();
        while (head.next != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.print(head.val);
    }
}
