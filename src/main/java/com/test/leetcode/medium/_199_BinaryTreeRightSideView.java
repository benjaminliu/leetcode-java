package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ben on 2017/10/18.
 */
public class _199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (null == root) return res;

        Queue<TreeNode> parentQ = new LinkedList<>();
        Queue<TreeNode> childQ = new LinkedList<>();
        Queue<TreeNode> tempQ;
        TreeNode temp;
        parentQ.add(root);
        while (!parentQ.isEmpty()) {
            temp = parentQ.poll();

            if (null != temp.left) {
                childQ.add(temp.left);
            }
            if (null != temp.right) {
                childQ.add(temp.right);
            }

            if (parentQ.isEmpty()) {
                res.add(temp.val);
                tempQ = parentQ;
                parentQ = childQ;
                childQ = tempQ;
            }
        }
        return res;
    }

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = q.remove();
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
                if (i == size - 1) {
                    result.add(t.val);
                }
            }
        }
        return result;
    }
}
