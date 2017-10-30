package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;
import com.test.leetcode.easy.FirstUniqueCharacterInAString;

import java.util.Stack;

/**
 * Created by ben on 2017/10/18.
 */
public class _173_BinarySearchTreeIterator {

    private TreeNode node;
    private Stack<TreeNode> stack;

    public _173_BinarySearchTreeIterator(TreeNode root) {
        node = root;
        stack = new Stack<>();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return null != node || !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode res = null;
        if (null == node) {
            res = stack.pop();
            node = res.right;
        } else {
            while (null != node.left) {
                stack.push(node);
                node = node.left;
            }
            res = node;
            node = node.right;
        }
        return res.val;
    }
}
