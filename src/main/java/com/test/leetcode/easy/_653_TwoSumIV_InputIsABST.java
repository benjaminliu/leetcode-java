package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/8/12.
 */
public class _653_TwoSumIV_InputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        List<Integer> arr = new ArrayList<Integer>();
        toArr(root, arr);
        int head = 0, tail = arr.size() - 1;
        while (head < tail) {
            if (arr.get(head) + arr.get(tail) == k)
                return true;
            else if (arr.get(head) + arr.get(tail) < k) {
                head++;
            } else tail--;
        }
        return false;
    }

    private void toArr(TreeNode node, List<Integer> arr) {
        if (node == null)
            return;
        toArr(node.left, arr);
        arr.add(node.val);
        toArr(node.right, arr);
    }


    public boolean findTarget1(TreeNode root, int k) {
        if (root == null)
            return false;


        return dfs(root, root, k);

    }

    private boolean dfs(TreeNode root, TreeNode curr, int target) {
        if (curr == null)
            return false;
        return search(root, curr, target - curr.val) || dfs(root, curr.left, target) || dfs(root, curr.right, target);
    }

    private boolean search(TreeNode node, TreeNode curr, int target) {
        if (node == null) return false;
        if (node.val == target && node != curr) {
            return true;
        } else if (node.val > target) {
            return search(node.left, curr, target);
        } else {
            return search(node.right, curr, target);
        }
    }
}
