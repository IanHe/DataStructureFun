##剑指 Offer 55 - II. 平衡二叉树 - Easy - https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
###same as: https://leetcode.com/problems/balanced-binary-tree/
![img of offer 55_II](imgs/offer%2055_II.png)
###Solution 1 - Post-Order Traverse & Prune - TC: O(N), SC: O(N) - 空间复杂度 O(N)： 最差情况下（树退化为链表时），系统递归需要使用 O(N) 的栈空间。
###https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/solution/mian-shi-ti-55-ii-ping-heng-er-cha-shu-cong-di-zhi/
```
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
```
###Solution 2 - Pre-Order Traverse Tree - TC: O(N logN), SC: O(N) - 空间复杂度 O(N)： 最差情况下（树退化为链表时），系统递归需要使用 O(N) 的栈空间。
```
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
```
![img of offer 55_II_1](imgs/offer%2055_II_1.png)