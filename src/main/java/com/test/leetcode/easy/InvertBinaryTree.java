package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

/**
 * Created by ben on 2017/5/27.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return root;
        }
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (null == root) {
            return;
        }
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        dfs(root.left);
        dfs(root.right);
    }
}
