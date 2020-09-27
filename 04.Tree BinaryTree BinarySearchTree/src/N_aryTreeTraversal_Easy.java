import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Difficulty: Easy
 * Name: N-ary Tree Preorder/LevelOrder/Postorder Traversal
 * Link: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/ or https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

public class N_aryTreeTraversal_Easy {
    /**
     * preorder iteration:
     * 1. Time Complexity: O(N), Space Complexity: O(N)
     */

    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            list.add(cur.val);
            for (int i = cur.children.size() - 1; i >= 0; i--) {
                stack.push(cur.children.get(i));
            }
        }
        return list;
    }

    /**
     * preorder recursion
     * 1. Time Complexity: O(N)
     */


    public List<Integer> preorder(Node root) {
        List<Integer> list= new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        for (Node child : root.children) {
            preorder(child, list);
        }
    }

    /**
     * postorder iteration
     * 1. Time complexity: O(N), Space complexity: O(N)
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pollFirst();
            list.offerFirst(cur.val);
            for (Node child : cur.children) {
                stack.addFirst(child);
            }
        }
        return list;
    }

    /**
     * postorder recursion
     * 1. Time complexity: O(N), Space complexity: O(N)
     */
    private List<Integer> postOrderList = new ArrayList<>();

    public List<Integer> postOrder_recursion(Node root) {
        if (root == null) return postOrderList;
        if (root.children != null && !root.children.isEmpty()) {
            for (Node child : root.children) {
                postOrder_recursion(child);
            }
        }
        postOrderList.add(root.val);
        return postOrderList;
    }

    /**
     * levelorder iteration
     * 1. Time complexity: O(N), Space complexity: O(N)
     */
    public List<List<Integer>> levelOrder_iteration(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        LinkedList<Node> dequeue = new LinkedList<>();
        dequeue.add(root);
        while (!dequeue.isEmpty()) {
            int count = dequeue.size();
            List<Integer> tempList = new ArrayList<>();
            while (count-- > 0) {
                Node cur = dequeue.pollLast();
                tempList.add(cur.val);
                for (Node node : cur.children) {
                    dequeue.addFirst(node);
                }
            }
            list.add(tempList);
        }
        return list;
    }

    /**
     * levelorder recursion
     * 1. Time complexity: O(N), Space complexity: O(N)
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        levelOrder_recursion(root, 0, list);
        return list;
    }

    private void levelOrder_recursion(Node root, int depth, List<List<Integer>> res) {
        if (root == null) return;
        if (depth + 1 > res.size()) {
            res.add(new ArrayList());
        }
        res.get(depth).add(root.val);
        for (Node child : root.children) {
            levelOrder_recursion(child, depth + 1, res);
        }
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
