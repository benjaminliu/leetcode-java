package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ben on 2017/10/16.
 */
public class _144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) return res;
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        res.add(root.val);
        if (null != root.left)
            dfs(root.left, res);
        if (null != root.right)
            dfs(root.right, res);
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList();
        Stack<TreeNode> stack = new Stack();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return list;
    }
}
