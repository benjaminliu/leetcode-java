package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

/**
 * Created by ben on 2017/8/12.
 */
public class _606_ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (null == t) return "";

        StringBuilder sb = new StringBuilder();
        helper(t, sb);
        return sb.toString();
    }

    private void helper(TreeNode t, StringBuilder sb) {
        sb.append(t.val);
        if (null == t.left && null == t.right) return;
        sb.append("(");
        if (null != t.left) {
            helper(t.left, sb);
        }
        sb.append(")");
        if (null == t.right) return;
        sb.append("(");
        if (null != t.right) {
            helper(t.right, sb);
        }
        sb.append(")");
    }
}
