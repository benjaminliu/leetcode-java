package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

/**
 * Created by ben on 2018/5/19.
 */
public class _814_BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (null == root)
            return null;

        int value = getValue(root);
        if (0 == value)
            return null;
        return root;
    }

    private int getValue(TreeNode root) {
        if (null == root)
            return 0;
        int leftValue = getValue(root.left);
        if (0 == leftValue)
            root.left = null;

        int rightValue = getValue(root.right);
        if (0 == rightValue)
            root.right = null;

        return leftValue + rightValue + root.val;
    }
}
