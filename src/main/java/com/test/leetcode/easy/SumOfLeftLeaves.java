package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

/**
 * Created by ben on 2017/5/29.
 */
public class SumOfLeftLeaves {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return sum;
    }

    private boolean dfs(TreeNode node) {
//        if (null == node) {
//            return false;
//        }
        if (null == node.left && null == node.right) {
            return true;
        }
        if (null != node.left) {
            if (dfs(node.left)) {
                sum += node.left.val;
            }
        }
        if (null != node.right) {
            dfs(node.right);
        }
        return false;
    }
}
