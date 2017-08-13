package com.test.leetcode.medium;


import com.test.leetcode.common.TreeNode;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ben on 2017/5/17.
 */
public class _513_FindBottomLeftTreeValue {

    private TreeNodeWapper result;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("root");
        }
        TreeNodeWapper rootWarpper = new TreeNodeWapper(root, 0);
        Queue<TreeNodeWapper> queue = new LinkedList<TreeNodeWapper>();
        queue.offer(rootWarpper);
        result = rootWarpper;
        int depth = result.getDepth();
        TreeNodeWapper wapper = null;
        while (!queue.isEmpty()) {
            wapper = queue.poll();
            if (wapper.getNode().left != null) {
                addChild(wapper.getNode().left, wapper.getDepth() + 1, depth, queue);
            }
            if (wapper.getNode().right != null) {
                addChild(wapper.getNode().right, wapper.getDepth() + 1, depth, queue);
            }
        }
        return result.getNode().val;
    }

    private void addChild(TreeNode node, int depth, int totalDepth, Queue<TreeNodeWapper> queue) {
        TreeNodeWapper temp = new TreeNodeWapper(node, depth);
        if (temp.getDepth() != totalDepth) {
            depth = temp.getDepth();
            if (result.getDepth() != depth) {
                result = temp;
            }
        }
        queue.offer(temp);
    }

    public static class TreeNodeWapper {
        private TreeNode node;
        private int depth;

        public TreeNodeWapper(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }

        public TreeNode getNode() {
            return node;
        }

        public int getDepth() {
            return depth;
        }
    }
}
