package com.test.leetcode.medium;

import com.test.leetcode.common.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ben on 2017/9/28.
 */
public class _116_PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {

        if (null == root) return;

        Queue<TreeLinkNode> pq = new LinkedList<>();
        Queue<TreeLinkNode> cq = new LinkedList<>();
        Queue<TreeLinkNode> t;

        TreeLinkNode temp;

        pq.add(root);
        while (!pq.isEmpty()) {
            temp = pq.poll();
            if (null != temp.left)
                cq.add(temp.left);
            if (null != temp.right)
                cq.add(temp.right);

            if (!pq.isEmpty()) {
                temp.next = pq.peek();
            } else {
                t = pq;
                pq = cq;
                cq = t;
            }
        }
    }
}
