package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/9/28.
 */
public class _113_PathSum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) return res;

        helper(res, root, sum, 0, new ArrayList<>());
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode root, int sum, int curSum, List<Integer> list) {

        curSum += root.val;

        if (null == root.left && null == root.right) {
            if (curSum == sum) {
                List<Integer> nodes = new ArrayList<>(list);
                nodes.add(root.val);
                res.add(nodes);
            }
        } else {
            List<Integer> nodes = new ArrayList<>(list);
            nodes.add(root.val);

            if (null != root.left) {
                helper(res, root.left, sum, curSum, nodes);
            }
            if (null != root.right) {
                helper(res, root.right, sum, curSum, nodes);
            }
        }
    }


    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, result, new ArrayList<>(), sum);
        return result;
    }

    private void pathSum(TreeNode root, List<List<Integer>> result, List<Integer> res, int sum) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (root.right == null && root.left == null && sum - root.val == 0) {
            result.add(new ArrayList(res));
            res.remove(res.size() - 1);
            return;
        }
        pathSum(root.left, result, res, sum - root.val);
        pathSum(root.right, result, res, sum - root.val);
        res.remove(res.size() - 1);
    }
}
