package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

/**
 * Created by ben on 2017/5/28.
 */
public class BinaryTreeTilt {
    int sum = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return sum;
    }

    private int dfs(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int left = 0;
        int right = 0;

        if (root.left != null) {
            left = dfs(root.left);
        }
        if (root.right != null) {
            right = dfs(root.right);
        }
        sum += Math.abs(left - right);
        return root.val + left + right;
    }
}
