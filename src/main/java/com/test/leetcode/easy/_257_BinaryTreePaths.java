package com.test.leetcode.easy;

import com.test.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/8/15.
 */
public class _257_BinaryTreePaths {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) return result;

        StringBuilder sb = new StringBuilder();

        helper(root, result, sb);

        return result;
    }

    private void helper(TreeNode root, List<String> result, StringBuilder sb) {
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
            return;
        }
        sb.append("->");
        int len = sb.length();
        if (null != root.left) {
            helper(root.left, result, sb);
        }
        sb.setLength(len);
        if (null != root.right) {
            helper(root.right, result, sb);
        }
        sb.setLength(len);
    }

    public List<String> binaryTreePaths1(TreeNode root) {
        ArrayList<String> ret = new ArrayList<>();
        if (root != null)
            helper1("", ret, root);
        return ret;
    }

    public void helper1(String tmp, List<String> ret, TreeNode root) {
        if (root.left == null && root.right == null) ret.add(tmp + root.val);
        if (root.left != null) helper1(tmp + root.val + "->", ret, root.left);
        if (root.right != null) helper1(tmp + root.val + "->", ret, root.right);
    }
}
