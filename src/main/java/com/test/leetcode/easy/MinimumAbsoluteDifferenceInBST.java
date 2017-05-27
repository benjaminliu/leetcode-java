package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

/**
 * Created by ben on 2017/5/27.
 */
public class MinimumAbsoluteDifferenceInBST {
    private int diff;
    private TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        diff = Integer.MAX_VALUE;
        helper(root);
        return diff;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (prev != null) {
            diff = Math.min(diff, root.val - prev.val);
        }
        prev = root;
        helper(root.right);
    }
}
