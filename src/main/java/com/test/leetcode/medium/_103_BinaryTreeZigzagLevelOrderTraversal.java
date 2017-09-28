package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

import java.util.*;

/**
 * Created by ben on 2017/9/27.
 */
public class _103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> pq = new LinkedList<>();
        Queue<TreeNode> cq = new LinkedList<>();
        Queue<TreeNode> t = null;
        TreeNode temp;
        pq.add(root);
        List<Integer> is = new ArrayList<>();
        boolean isForward = true;
        while (!pq.isEmpty()) {
            temp = pq.poll();
            is.add(temp.val);
            if (null != temp.left) cq.add(temp.left);
            if (null != temp.right) cq.add(temp.right);
            if (pq.isEmpty()) {
                if (isForward == false) Collections.reverse(is);
                res.add(is);
                if (cq.isEmpty()) break;
                is = new ArrayList<>();
                t = pq;
                pq = cq;
                cq = t;
                isForward = !isForward;
            }
        }
        return res;
    }
}
