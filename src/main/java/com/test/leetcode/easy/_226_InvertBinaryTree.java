package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

/**
 * Created by ben on 2017/5/27.
 */
public class _226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return root;
        }
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (null != root.left) {
            dfs(root.left);
        }
        if (null != root.right) {
            dfs(root.right);
        }
    }
}
