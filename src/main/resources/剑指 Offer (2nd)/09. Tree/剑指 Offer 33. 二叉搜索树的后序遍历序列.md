##剑指 Offer 33. 二叉搜索树的后序遍历序列 - Medium - https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
![offer 33](imgs/offer%2033.png)
###Solution - Divide & Conquer - TC: O(N^2), SC: O(N)
###https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
```
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++; // j is the root node in [i, j]
        int m = p; // m is the divide node for left/right tree
        while (postorder[p] > postorder[j]) p++; // find p, the right tree boundary should be equal to j
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
```
![offer_33_I](imgs/offer%2033_I.png)