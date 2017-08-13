package com.test.leetcode.medium;

import com.test.leetcode.common.ListNode;

import java.util.Random;

/**
 * Created by ben on 2017/5/24.
 */
public class _382_LinkedListRandomNode {
    private ListNode head;
    private Random random;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public _382_LinkedListRandomNode(ListNode head) {
        if (head == null) {
            throw new IllegalArgumentException("head");
        }
        this.head = head;
        random = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode temp = head;

        int val = head.val;
        for (int i = 1; temp != null; i++) {
            if (random.nextInt(i) == 0) {
                val = temp.val;
            }
            temp = temp.next;
        }
        return val;
    }
}
