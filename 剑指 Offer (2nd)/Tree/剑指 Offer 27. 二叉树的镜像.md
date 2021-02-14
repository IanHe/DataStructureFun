##剑指 Offer 27. 二叉树的镜像 - Easy - https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
###same as: https://leetcode-cn.com/problems/invert-binary-tree/
###Solution - DFS - TC: O(N), SC: O(N)
```
    public TreeNode mirrorTree(TreeNode root) { 
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(left);
        return root;
    }
```
###Solution - BFS - TC: O(N), SC: O(N)
```
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }
        }
        return root;
    }
```