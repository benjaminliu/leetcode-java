package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * Created by ben on 2017/10/17.
 */
public class _156_BinaryTreeUpsideDown {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        if (root == null) return null;
        while (root.left != null) {
            stack.push(root);
            root = root.left;
        }
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (!stack.empty()) {
                node.right = stack.peek();
                node.left = stack.peek().right;
            } else {
                node.left = null;
                node.right = null;
            }
        }
        return root;
    }
}
