package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

/**
 * Created by ben on 2017/5/20.
 */
public class _538_ConvertBSTToGreaterTree {

    private int last = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            rightMidLeft(root);
        }
        return root;
    }

    private void rightMidLeft(TreeNode node) {
        if (node.right != null) {
            rightMidLeft(node.right);
        }

        node.val += last;
        last = node.val;

        if (node.left != null) {
            rightMidLeft(node.left);
        }
    }
}
