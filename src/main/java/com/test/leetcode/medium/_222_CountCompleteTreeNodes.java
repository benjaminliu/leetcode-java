package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

/**
 * Created by ben on 2017/10/25.
 */
public class _222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (null == root) return 0;
        int l = getLeftHeight(root) + 1;
        int r = getRightHeight(root) + 1;

        if (l == r)
            return (2 << (l - 1)) - 1;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getRightHeight(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            root = root.left;
            count++;
        }
        return count;
    }

    private int getLeftHeight(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            root = root.right;
            count++;
        }
        return count;
    }


    int height = 0;
    int count = 0;

    public int countNodes1(TreeNode root) {
        int rightHeight = 0;
        if (root == null)
            return this.count;
        this.height = getHeight(root);
        while (root != null) {
            rightHeight = getHeight(root.right);
            if (rightHeight == this.height - 1) {
                count += 1 << (this.height - 1);
                root = root.right;
                this.height--;
            } else {
                this.count += 1 << (rightHeight);
                root = root.left;
                this.height--;
            }
        }
        return this.count;
    }

    int getHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }

    public int countNodes2(TreeNode root) {
        if (null == root) return 0;
        if (null == root.left && null == root.right) return 1;
        if (null == root.right) return 2;

        int l = getHeight(root.left);
        int r = getHeight(root.right);

        //if( l == r ), left sub_tree is complete binary tree
        //if( l != r ), right sub_tree is complete binary tree;
        if (l == r) {
            int leftCount = (2 << (l - 1)) - 1;
            return leftCount + 1 + countNodes(root.right);
        } else {
            int rightCount = (2 << (r - 1)) - 1;
            return rightCount + 1 + countNodes(root.left);
        }
    }
}
