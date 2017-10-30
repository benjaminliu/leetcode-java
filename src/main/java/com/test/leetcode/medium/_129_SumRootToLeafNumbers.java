package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

/**
 * Created by ben on 2017/9/28.
 */
public class _129_SumRootToLeafNumbers {
    private int sum;

    public int sumNumbers(TreeNode root) {
        if (null == root) return 0;

        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int temp) {
        temp = temp * 10 + root.val;
        if (null == root.left && null == root.right) {
            sum += temp;
            return;
        }
        if (null != root.left) {
            helper(root.left, temp);
        }

        if (null != root.right) {
            helper(root.right, temp);
        }
    }
}
