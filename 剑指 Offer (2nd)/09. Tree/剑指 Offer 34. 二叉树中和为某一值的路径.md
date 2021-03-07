##剑指 Offer 34. 二叉树中和为某一值的路径 - Medium - https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
###https://leetcode-cn.com/problems/path-sum-ii/
![img of offer 34](imgs/offer%2034.png)
###Solution - Backtrace - TC: O(N), SC: O(N)
###https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/mian-shi-ti-34-er-cha-shu-zhong-he-wei-mou-yi-zh-5/
```
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum, new LinkedList<>());
        return res;
    }

    private void recur(TreeNode node, int target, LinkedList<Integer> path) {
        if (node == null) return;
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) res.add(new ArrayList<>(path));
        recur(node.left, target, path);
        recur(node.right, target, path);
        path.removeLast();
    }
```
![img of offer 34_I](imgs/offer%2034_I.png)