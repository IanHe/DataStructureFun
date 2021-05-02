import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MainTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        int[] nums = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        sol.bubbleSort(nums);
//        sol.selectionSort(nums);
//        sol.insertionSort(nums);
//        sol.quickSort(nums);
        sol.mergeSort(nums);
        Arrays.stream(nums).forEach(num -> System.out.print(num + ", "));
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>() {{
            push(root);
        }};
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.addFirst(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return res;
    }
}

class TreeNode {
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