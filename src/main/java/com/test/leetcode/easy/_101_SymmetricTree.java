package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ben on 2017/8/13.
 */
public class _101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) return true;

        Queue<TreeNode> parents = new LinkedList<>();
        List<TreeNode> nodes = new ArrayList<>();
        parents.add(root);
        TreeNode temp;
        while (true) {
            nodes.clear();
            while (!parents.isEmpty()) {
                temp = parents.poll();
                nodes.add(temp.left);
                nodes.add(temp.right);
            }
            int len = nodes.size();
            if (len == 0) return true;
            if (len % 2 == 1) return false;

            int start = 0;
            int end = len - 1;
            while (start < end) {
                TreeNode t1 = nodes.get(start++);
                TreeNode t2 = nodes.get(end--);
                if (t1 == null && t2 == null) {

                } else if (t1 == null) {
                    return false;
                } else if (t2 == null) {
                    return false;
                } else {
                    if (t1.val != t2.val) return false;
                }
            }
            for (TreeNode n : nodes) {
                if (n != null) {
                    parents.add(n);
                }
            }
        }
    }

    public boolean isSymmetric1(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }
}
