package com.test.leetcode.medium;

import com.test.leetcode.common.TreeLinkNode;

/**
 * Created by ben on 2017/6/2.
 */
public class _117_PopulatingNextRightPointersInEachNodeII {


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
