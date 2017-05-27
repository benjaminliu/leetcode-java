package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

/**
 * Created by ben on 2017/5/27.
 */
public class MaximumDepthOfBinaryTree {
    private int depth;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, 1);
        return depth;
    }

    private void dfs(TreeNode node, int i) {
        if (node == null) {
            return;
        }
        if (i > depth) {
            depth = i;
        }
        dfs(node.left, i + 1);
        dfs(node.right, i + 1);
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_dep = maxDepth(root.left) + 1;
        int right_dep = maxDepth(root.right) + 1;
        return Math.max(left_dep, right_dep);
    }

}
