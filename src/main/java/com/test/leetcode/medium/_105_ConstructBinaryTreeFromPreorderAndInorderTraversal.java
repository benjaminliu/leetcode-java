package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

import java.util.*;

/**
 * Created by ben on 2017/9/27.
 */
public class _105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length < 1) {
            return null;
        }

        HashMap<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, inorderMap, 0, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, HashMap<Integer, Integer> inorderMap, int preCur, int inStart, int inEnd) {
        TreeNode root = new TreeNode(preorder[preCur]);
        int inMid = inorderMap.get(preorder[preCur]);

        if (inStart < inEnd) {
            if (inStart < inMid) {
                root.left = helper(preorder, inorderMap, preCur + 1, inStart, inMid - 1);
            }

            if (inMid < inEnd) {
                //inMid - inStart + 1 ,  this is left sub-tree's nodes count,
                //in preorder,  right sub-tree's nodes are after left sub-tree's nodes.
                root.right = helper(preorder, inorderMap, preCur + (inMid - inStart + 1), inMid + 1, inEnd);
            }
        }
        return root;
    }
}
