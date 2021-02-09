import org.testng.annotations.Test;

import java.util.HashMap;


public class SolutionSpec {

    @Test
    public void testSolution() {

    }
}


class Sol {
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>(); //标记中序数组

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }

    private TreeNode recur(int root, int inOrderLeft, int inOrderRight) {
        if (inOrderLeft > inOrderRight) return null; // 递归终止
        TreeNode node = new TreeNode(preorder[root]); // 建立根节点
        int i = dic.get(preorder[root]); // 找到根结点在中序遍历中的位置，划分根节点、左子树、右子树
        node.left = recur(root + 1, inOrderLeft, i - 1); // 开启左子树递归
        int rightRoot = root + i - inOrderLeft + 1; // preorder中右子树的index
        node.right = recur(rightRoot, i + 1, inOrderRight); // 开启右子树递归
        return node;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}