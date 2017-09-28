package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/9/28.
 */
public class _106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (null == inorder || inorder.length == 0) return null;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(postorder, map, inorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, Map<Integer, Integer> inMap, int postCur, int inStart, int inEnd) {
        int value = postorder[postCur];
        TreeNode node = new TreeNode(value);
        int inMid = inMap.get(value);
        if (inStart < inEnd) {
            if (inStart < inMid) {
                node.left = helper(postorder, inMap, postCur - (inEnd - inMid + 1), inStart, inMid - 1);
            }

            if (inMid < inEnd) {
                node.right = helper(postorder, inMap, postCur - 1, inMid + 1, inEnd);
            }
        }

        return node;
    }
}
