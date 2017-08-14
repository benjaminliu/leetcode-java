package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

/**
 * Created by ben on 2017/8/14.
 */
public class _112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) return false;

        return helper(root, 0, sum);
    }

    private boolean helper(TreeNode root, int tempSum, int sum) {
        tempSum += root.val;
        if (null == root.left && null == root.right) {
            if (tempSum == sum) return true;
            return false;
        }

        if (root.left != null) {
            if (helper(root.left, tempSum, sum)) {
                return true;
            }
        }

        if (root.right != null) {
            if (helper(root.right, tempSum, sum)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum1(root.right, sum - root.val) || hasPathSum1(root.left, sum - root.val);
    }
}
