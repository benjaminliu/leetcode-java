package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ben on 2017/7/4.
 */
public class _94BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null != root) {
            inorder(root, result);
        }
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (null != root.left) {
            inorder(root.left, result);
        }
        result.add(root.val);
        if (null != root.right) {
            inorder(root.right, result);
        }
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = null;
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (cur.left != null) {
                stack.push(cur.left);
                continue;
            }
            result.add(cur.val);
            stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return result;
    }
}
