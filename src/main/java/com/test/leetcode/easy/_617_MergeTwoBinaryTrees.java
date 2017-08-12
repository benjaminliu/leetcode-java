package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

/**
 * Created by ben on 2017/8/12.
 */
public class _617_MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (null == t1) return t2;

        if (null == t2) return t1;

        TreeNode t = new TreeNode(-1);

        helper(t, t1, t2);

        return t;
    }

    private void helper(TreeNode t, TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return;

        if (t1 == null) {
            helper(t, t2);
        } else if (t2 == null) {
            helper(t, t1);
        } else {
            t.val = t1.val + t2.val;
            if (null != t1.left || null != t2.left) {
                t.left = new TreeNode(-1);
                helper(t.left, t1.left, t2.left);
            }
            if (null != t1.right || null != t2.right) {
                t.right = new TreeNode(-1);
                helper(t.right, t1.right, t2.right);
            }
        }
    }

    private void helper(TreeNode t, TreeNode t1) {
        t.val = t1.val;
        if (null != t1.left) {
            t.left = new TreeNode(t1.left.val);
            helper(t.left, t1.left);
        }
        if (null != t1.right) {
            t.right = new TreeNode(t1.right.val);
            helper(t.right, t1.right);
        }
    }


    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode cur = new TreeNode(val);
        cur.left = mergeTrees1(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        cur.right = mergeTrees1(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return cur;
    }
}
