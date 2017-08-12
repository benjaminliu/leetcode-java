package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ben on 2017/8/12.
 */
public class _637_AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (null == root) return result;

        List<Long> map = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        helper(root, map, counts, 0);

        for (int i = 0; i < map.size(); i++) {
            result.add((double) map.get(i) / counts.get(i));
        }
        return result;
    }

    private void helper(TreeNode root, List<Long> map, List<Integer> counts, int i) {
        if (i >= map.size()) {
            map.add(0L);
            counts.add(0);
        }
        map.set(i, map.get(i) + root.val);
        counts.set(i, counts.get(i) + 1);
        if (null != root.left) {
            helper(root.left, map, counts, i + 1);
        }
        if (null != root.right) {
            helper(root.right, map, counts, i + 1);
        }
    }
}
