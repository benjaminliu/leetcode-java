package com.test.leetcode.medium;

import com.test.leetcode.common.TreeNode;

import java.util.*;

/**
 * Created by ben on 2017/9/22.
 */
public class _95_UniqueBinarySearchTrees_II {
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<TreeNode>();
        if (n == 0) {
            return result[0];
        }

        result[0].add(null);
        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<TreeNode>();
            for (int j = 0; j < len; j++) {
                for (TreeNode nodeL : result[j]) {
                    for (TreeNode nodeR : result[len - j - 1]) {
                        TreeNode node = new TreeNode(j + 1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j + 1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    private static TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

    public List<TreeNode> generateTrees1(int n) {
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            return res;
        } else if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        List<TreeNode> ltrees = helper(start, end - 1);
        for (int i = 0; i < ltrees.size(); ++i) {
            TreeNode cur = new TreeNode(end);
            cur.left = ltrees.get(i);
            res.add(cur);
        }
        List<TreeNode> rtrees = helper(start + 1, end);
        for (int i = 0; i < rtrees.size(); ++i) {
            TreeNode cur = new TreeNode(start);
            cur.right = rtrees.get(i);
            res.add(cur);
        }
        for (int i = start + 1; i < end; ++i) {
            ltrees = helper(start, i - 1);
            rtrees = helper(i + 1, end);
            for (int j = 0; j < ltrees.size(); ++j) {
                for (int k = 0; k < rtrees.size(); ++k) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = ltrees.get(j);
                    cur.right = rtrees.get(k);
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
