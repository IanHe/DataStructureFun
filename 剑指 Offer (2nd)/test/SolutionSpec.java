import org.testng.annotations.Test;


public class SolutionSpec {

    @Test
    public void testSolution() {
        Sol sol = new Sol();
        Sol.TreeNode node1 = new Sol.TreeNode(1);
        Sol.TreeNode node2 = new Sol.TreeNode(2);
        Sol.TreeNode node3 = new Sol.TreeNode(3);
        node1.right = node2;
        node2.right = node3;
        System.out.println(sol.isBalanced(node1));
    }
}


class Sol {
    /*
      返回值：
        当节点root 左 / 右子树的深度差 ≤1 ：则返回当前子树的深度，即节点 root 的左 / 右子树的深度最大值 +1 （ max(left, right) + 1 ）；
        当节点root 左 / 右子树的深度差 >2 ：则返回 −1 ，代表 此子树不是平衡树 。
      终止条件：
        当 root 为空：说明越过叶节点，因此返回高度 0 ；
        当左（右）子树深度为 -1 ：代表此树的 左（右）子树 不是平衡树，因此剪枝，直接返回 -1 ；
     */
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//896
}
