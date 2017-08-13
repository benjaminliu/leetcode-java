package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/8/13.
 */
public class _110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (null == root) return true;

        int height = helper(root);
        if (-1 == height) return false;

        return true;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        if (left == -1) return -1;

        int right = helper(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
