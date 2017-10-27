package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

/**
 * Created by ben on 2017/10/26.
 */
public class _230_KthSmallestElementInABST {
    private int count = 0;
    private TreeNode res;

    public int kthSmallest(TreeNode root, int k) {
        if (null == root) return 0;
        dfs(root, k);
        return res.val;
    }

    private void dfs(TreeNode root, int k) {
        if (null != root.left) dfs(root.left, k);
        count++;
        if (count == k) {
            res = root;
            return;
        }
        if (null != root.right) dfs(root.right, k);
    }
}
