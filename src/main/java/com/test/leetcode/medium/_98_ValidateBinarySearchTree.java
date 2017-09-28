package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by ben on 2017/9/27.
 */
public class _98_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBST1(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkBST(TreeNode root, long min, long max) {

        if (root == null) return true;
        if (root.val < min || root.val > max) return false;
        boolean isLeftBST = checkBST(root.left, min, (long) root.val - 1);
        boolean isRightBST = checkBST(root.right, (long) root.val + 1, max);

        if (isLeftBST && isRightBST) return true;
        return false;
    }
}
