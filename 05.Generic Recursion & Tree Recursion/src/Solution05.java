import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution05 {
    public static void main(String[] args) {
        Solution05 solution05 = new Solution05();
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(2);
        TreeNode node_4 = new TreeNode(2);
        TreeNode node_5 = new TreeNode(2);

        node_1.left = node_2;
        node_1.right = node_3;
        node_3.left = node_4;
        node_3.right = node_5;
        System.out.println(solution05.serialize(node_1));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return "";
        Queue<TreeNode> qu=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        qu.offer(root);
        sb.append(String.valueOf(root.val));
        sb.append(' ');
        while (!qu.isEmpty()) {
            TreeNode x=qu.poll();
            if (x.left==null) sb.append("null ");
            else {
                qu.offer(x.left);
                sb.append(String.valueOf(x.left.val));
                sb.append(' ');
            }
            if (x.right==null) sb.append("null ");
            else {
                qu.offer(x.right);
                sb.append(String.valueOf(x.right.val));
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()==0) return null;
        String[] node=data.split(" ");
        Queue<TreeNode> qu=new LinkedList<>();
        TreeNode root=new TreeNode(Integer.valueOf(node[0]));
        qu.offer(root);
        int i=1;
        while (!qu.isEmpty()) {
            Queue<TreeNode> nextQu=new LinkedList<>();
            while (!qu.isEmpty()) {
                TreeNode x=qu.poll();
                if (node[i].equals("null")) x.left=null;
                else {
                    x.left=new TreeNode(Integer.valueOf(node[i]));
                    nextQu.offer(x.left);
                }
                i++;
                if (node[i].equals("null")) x.right=null;
                else {
                    x.right=new TreeNode(Integer.valueOf(node[i]));
                    nextQu.offer(x.right);
                }
                i++;
            }
            qu=nextQu;
        }
        return root;
    }

    public static class TreeNode {
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
