import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Difficulty: Medium
 * Name: Binary Tree Inorder Traversal
 * Link: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/ or https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeTraversal_Medium {
    public static void main(String[] args) {

    }

    /**
     * Iteration: using stack
     * Time Complexity: O(N), Space Complexity: O(h) - h is the height of the tree
     */
    public static List<Integer> inorderTraversal_iteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (stack.size() > 0 || root != null) {
            // continue traverse left
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode tmp = stack.pop();
                list.add(tmp.val);
                root = tmp.right;
            }
        }
        return list;
    }

    public static List<Integer> preorderTraversal_iteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
        return list;
    }

    /**
     * Recursion:
     * preorder: print -> left -> right
     * inorder: left -> print -> right
     * postorder: left -> right -> print
     * Time Complexity: O(N), Space Complexity: O(h) - h is the height of the tree
     */
    public static List<Integer> traversal_recursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(list, root);
//        preorder(list, root);
//        postorder(list, root);
        return list;
    }

    private static void inorder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }

    private static void preorder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        preorder(list, root.left);
        preorder(list, root.right);
    }

    private static void postorder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        postorder(list, root.left);
        postorder(list, root.right);
        list.add(root.val);
    }

    //    Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
