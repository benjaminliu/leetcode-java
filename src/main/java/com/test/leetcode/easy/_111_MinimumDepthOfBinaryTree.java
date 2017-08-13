package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ben on 2017/8/13.
 */
public class _111_MinimumDepthOfBinaryTree {
    private int min = Integer.MAX_VALUE; // 记录树的最小深度
    private int cur = 0; // i当前处理的树的尝试

    public int minDepth(TreeNode root) {

        depth(root);
        return min;
    }

    private void depth(TreeNode node) {

        if (node == null) {
            min = cur;
            return;
        }

        cur++; // 当前处理的层次加1

        // 如果是叶节点，并且路径比记录的最小还小
        if (node.left == null && node.right == null && cur < min) {
            min = cur; // 更新最小值
        }
        // 处理左子树
        if (node.left != null) {
            depth(node.left);
        }

        // 处理右子树
        if (node.right != null) {
            depth(node.right);
        }

        cur--; // 还原
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
