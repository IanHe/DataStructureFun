##剑指 Offer 36. 二叉搜索树与双向链表 - Medium - https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
###https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
![img of offer 36](imgs/offer%2036.png)
###Solution 1 - DFS - TC: O(N), SC: O(N)
###https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/
```
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (pre != null) pre.right = cur;
        else head = cur; // head will only be assigned once
        cur.left = pre;
        pre = cur; // finally, pre will be the last node
        dfs(cur.right);
    }
```
![img of offer 36_I](imgs/offer%2036_I.png)