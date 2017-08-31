package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/8/23.
 */
public class _437_PathSum_III {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val)
                + pathSumFrom(node.right, sum - node.val);
    }


    int result = 0;

    public int pathSum2(TreeNode root, int sum) {
        if (root == null) return result;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        helper(root, sum, 0, map);
        return result;
    }

    private void helper(TreeNode root, int sum, int val, Map<Integer, Integer> map) {
        if (root == null) return;
        val += root.val;
        if (map.containsKey(val - sum)) result += map.get(val - sum);
        int count = map.getOrDefault(val, 0) + 1;
        map.put(val, count);
        helper(root.left, sum, val, map);
        helper(root.right, sum, val, map);
        map.put(val, count - 1);
    }
}
