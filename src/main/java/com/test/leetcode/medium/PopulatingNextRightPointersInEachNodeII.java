package com.test.leetcode.medium;

/**
 * Created by ben on 2017/6/2.
 */
public class PopulatingNextRightPointersInEachNodeII {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        TreeLinkNode queue = root;
        TreeLinkNode level = new TreeLinkNode(0);
        while (queue != null) {
            level.next = null;
            TreeLinkNode current = level;
            while (queue != null) {
                if (queue.left != null) {
                    current.next = queue.left;
                    current = current.next;
                }
                if (queue.right != null) {
                    current.next = queue.right;
                    current = current.next;
                }
                queue = queue.next;
            }
            queue = level.next;
        }
    }
}
