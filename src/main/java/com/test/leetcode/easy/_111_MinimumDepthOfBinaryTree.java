package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ben on 2017/8/13.
 */
public class _111_MinimumDepthOfBinaryTree {
    private int min = Integer.MAX_VALUE;
    private int cur = 0;

    public int minDepth(TreeNode root) {

        depth(root);
        return min;
    }

    private void depth(TreeNode node) {

        if (node == null) {
            min = cur;
            return;
        }

        cur++;


        if (node.left == null && node.right == null && cur < min) {
            min = cur;
        }

        if (node.left != null) {
            depth(node.left);
        }


        if (node.right != null) {
            depth(node.right);
        }

        cur--;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth1(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth1(root.left) + 1;
        }
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        return left < right ? left + 1 : right + 1;
    }
}
