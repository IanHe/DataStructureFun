##剑指 Offer 54. 二叉搜索树的第k大节点 - Easy - https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
![img of offer 54](imgs/offer%2054.png)
###Solution - Inverse Inorder-Traversal - TC: O(N), SC: O(1)
```
    int counter = 0, res = 0;

    public int kthLargest(TreeNode node, int k) {
        if (node.right != null) kthLargest(node.right, k);
        if (++counter == k) {
            res = node.val;
        }
        if (node.left != null) kthLargest(node.left, k);
        return res;
    }
```
![img of offer 54_1](imgs/offer%2054_1.png)