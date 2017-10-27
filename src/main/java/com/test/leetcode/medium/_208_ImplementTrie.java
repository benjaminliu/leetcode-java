package com.test.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/10/23.
 */
public class _208_ImplementTrie {

    class TreeNode {
        TreeNode[] children;
        boolean end;

        public TreeNode() {
            this.children = new TreeNode[26];
            this.end = false;
        }
    }

    private TreeNode root;

    public _208_ImplementTrie() {
        this.root = new TreeNode();
    }


    public void insert(String s) {
        TreeNode it = root;
        for (int i = 0; i < s.length(); i++) {
            if (it.children[s.charAt(i) - 'a'] == null) {
                it.children[s.charAt(i) - 'a'] = new TreeNode();
            }
            it = it.children[s.charAt(i) - 'a'];
        }
        it.end = true;
    }

    public boolean search(String s) {
        TreeNode it = root;
        for (int i = 0; i < s.length(); i++) {
            if (it.children[s.charAt(i) - 'a'] == null)
                return false;
            it = it.children[s.charAt(i) - 'a'];
        }
        if (!it.end)
            return false;
        return true;
    }

    public boolean startsWith(String s) {
        TreeNode it = root;
        for (int i = 0; i < s.length(); i++) {
            if (it.children[s.charAt(i) - 'a'] == null)
                return false;
            it = it.children[s.charAt(i) - 'a'];
        }
        return true;
    }
}
