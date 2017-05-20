package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ben on 2017/5/20.
 */
public class MostFrequentSubtreeSum {
    private Map<Integer, Integer> result;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        result = new HashMap<>();
        lastTravesal(root);

        int[] arr = new int[result.size()];
        int max = 1;
        int maxKey = 0;
        List<Integer> maxs = new ArrayList<>();
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            arr[i] = entry.getKey();
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxKey = entry.getKey();
                maxs.clear();
                maxs.add(maxKey);
            } else if (entry.getValue() == max) {
                maxs.add(entry.getKey());
            }
            i++;
        }
        if (max > 1) {
            arr = new int[maxs.size()];
            for (int j = 0, length = maxs.size(); j < length; j++) {
                arr[j] = maxs.get(j);
            }
        }
        return arr;
    }

    private int lastTravesal(TreeNode node) {
        int a = 0, b = 0;
        if (node.left != null) {
            a = lastTravesal(node.left);
        }
        if (node.right != null) {
            b = lastTravesal(node.right);
        }
        node.val += a + b;
        if (result.keySet().contains(node.val)) {
            result.put(node.val, result.get(node.val) + 1);
        } else {
            result.put(node.val, 1);
        }
        return node.val;
    }
}
