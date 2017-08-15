package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ben on 2017/8/15.
 */
public class _270_ClosestBinarySearchTreeValue {

    //Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

    //Note:
    // Given target value is a floating point.
    // You are guaranteed to have only one unique value in the BST that is closest to the target.

    public int closestValue(TreeNode root, double target) {
        if (null == root) return -1;
        TreeMap<Integer, Double> map = new TreeMap<>();
        helper(root, map, target);

        return map.firstEntry().getKey();
    }

    private void helper(TreeNode root, Map<Integer, Double> map, double target) {
        double diff = Math.abs(target - root.val);
        map.put(root.val, diff);
        if (root.val > target) {
            if (null != root.left) {
                helper(root.left, map, target);
            }
        } else {
            if (null != root.right) {
                helper(root.right, map, target);
            }
        }
    }


    public int closestValue1(TreeNode root, double target) {

        int closest = root.val;
        double min = Double.MAX_VALUE;

        while (root != null) {
            if (Math.abs(root.val - target) < min) {
                min = Math.abs(root.val - target);
                closest = root.val;
            }

            if (target < root.val) {
                root = root.left;
            } else if (target > root.val) {
                root = root.right;
            } else {
                return root.val;
            }
        }

        return closest;
    }
}
