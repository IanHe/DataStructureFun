import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;


public class SolutionSpec {

    @Test
    public void testSolution() {
        Sol sol = new Sol();
        int[] arr = new int[]{6, 4, 2, 1};

    }
}


class Sol {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
//896
}
