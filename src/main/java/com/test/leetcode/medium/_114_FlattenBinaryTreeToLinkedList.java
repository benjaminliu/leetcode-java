package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

/**
 * Created by ben on 2017/9/28.
 */
public class _114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (null == root) return;

        root = helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (null == root) return null;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        root.left = null;
        if (null != left) {
            root.right = left;
            while (null != left.right) {
                left = left.right;
            }
            left.right = right;
        } else {
            root.right = right;
        }
        return root;
    }
}
