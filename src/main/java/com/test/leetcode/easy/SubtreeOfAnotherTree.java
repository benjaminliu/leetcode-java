package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ben on 2017/6/15.
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (null == s || null == t) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (compareTree(cur, t)) {
                return true;
            }
            if (null != cur.left) {
                queue.offer(cur.left);
            }
            if (null != cur.right) {
                queue.offer(cur.right);
            }
        }
        return false;
    }

    private boolean compareTree(TreeNode cur, TreeNode t) {
        if (cur.val != t.val) {
            return false;
        }

        if (cur.left == null && t.left != null) {
            return false;
        }
        if (cur.left != null && t.left == null) {
            return false;
        }
        if (cur.left != null && t.left != null) {
            if (!compareTree(cur.left, t.left)) {
                return false;
            }
        }
        if (cur.right == null && t.right != null) {
            return false;
        }
        if (cur.right != null && t.right == null) {
            return false;
        }
        if (cur.right != null && t.right != null) {
            if (!compareTree(cur.right, t.right)) {
                return false;
            }
        }
        return true;
    }
}
