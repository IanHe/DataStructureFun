import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.deserialize("1,2,3,null,null,4,5");
        String str = solution.serialize(root);
        System.out.println(str);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) sb.append("null,");
            else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] list = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(list[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < list.length) {
            TreeNode node = queue.poll();
            String leftVal = list[i];
            String rightVal = list[i + 1];

            if (!leftVal.equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(leftVal));
                node.left = left;
                queue.offer(left);
            }

            if (!rightVal.equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(rightVal));
                node.right = right;
                queue.offer(right);
            }
            i += 2; // every time read 2 nodes - left,right
        }
        return root;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}