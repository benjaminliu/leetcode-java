package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ben on 2017/9/27.
 */
public class _102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> pq = new LinkedList<>();
        Queue<TreeNode> cq = new LinkedList<>();
        Queue<TreeNode> t = null;
        TreeNode temp;
        pq.add(root);
        List<Integer> is = new ArrayList<>();
        while (!pq.isEmpty()) {
            temp = pq.poll();
            is.add(temp.val);
            if (null != temp.left) cq.add(temp.left);
            if (null != temp.right) cq.add(temp.right);
            if (pq.isEmpty()) {
                res.add(is);
                if (cq.isEmpty()) break;
                is = new ArrayList<>();
                t = pq;
                pq = cq;
                cq = t;
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res, 0);
        return res;
    }

    public void helper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(new ArrayList());
        }
        res.get(level).add(root.val);
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}
