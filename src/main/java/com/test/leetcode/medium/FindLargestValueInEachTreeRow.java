package com.test.leetcode.medium;

import java.util.*;

/**
 * Created by ben on 2017/5/19.
 */
public class FindLargestValueInEachTreeRow {

    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public class TreeNodeWarpper {
        TreeNode node;
        int depth;

        TreeNodeWarpper(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        TreeNodeWarpper warpper = new TreeNodeWarpper(root, 0);
        Queue<TreeNodeWarpper> queue = new LinkedList<>();
        queue.offer(warpper);
        int depth = 0;
        int max = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        TreeNodeWarpper temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.depth != depth) {
                result.add(max);
                max = Integer.MIN_VALUE;
                depth++;
            }
            if (max < temp.node.val) {
                max = temp.node.val;
            }
            if (null != temp.node.left) {
                queue.offer(new TreeNodeWarpper(temp.node.left, temp.depth + 1));
            }
            if (null != temp.node.right) {
                queue.offer(new TreeNodeWarpper(temp.node.right, temp.depth + 1));
            }
        }
        result.add(max);
        return result;
    }

    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> maxLevel = new ArrayList<Integer>();
        dfsHelper(root, maxLevel, 0);
        return maxLevel;
    }

    public void dfsHelper(TreeNode root, List<Integer> arr, int level) {
        if (root == null) {
            return;
        }
        if (level >= arr.size()) {
            arr.add(root.val);
        } else if (root.val > arr.get(level)) {
            arr.set(level, root.val);
        }
        dfsHelper(root.left, arr, level + 1);
        dfsHelper(root.right, arr, level + 1);
    }
}
