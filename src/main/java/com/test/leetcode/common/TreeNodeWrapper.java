package com.test.leetcode.common;

/**
 * Created by ben on 2017/5/20.
 */
public class TreeNodeWrapper {
    public TreeNode node;
    public int depth;

    public TreeNodeWrapper(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}
