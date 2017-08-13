package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ben on 2017/8/13.
 */
public class _107_BinaryTreeLevelOrderTraversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        result.add(temp);

        Queue<TreeNode> parents = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<TreeNode> change;
        TreeNode t;
        parents.add(root);
        while (true) {
            temp = new ArrayList<>();
            while (!parents.isEmpty()) {
                t = parents.poll();
                if (null != t.left) {
                    nodes.add(t.left);
                    temp.add(t.left.val);
                }
                if (null != t.right) {
                    nodes.add(t.right);
                    temp.add(t.right.val);
                }
            }
            if (nodes.size() == 0) break;
            result.add(temp);

            change = parents;
            parents = nodes;
            nodes = change;
        }

        List<List<Integer>> r = new ArrayList<>(result.size());
        for (int i = result.size() - 1; i >= 0; i--) {
            r.add(result.get(i));
        }
        return r;
    }

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        Traverse(root, 0, results);
        return results;
    }

    private void Traverse(TreeNode root, int currDepth, List<List<Integer>> results) {
        if (root == null) {
            return;
        }

        if (currDepth >= results.size()) {
            List<Integer> list = new ArrayList<>();
            results.add(0, list);
        }

        Traverse(root.left, currDepth + 1, results);
        Traverse(root.right, currDepth + 1, results);
        results.get(results.size() - currDepth - 1).add(root.val);
    }
}
