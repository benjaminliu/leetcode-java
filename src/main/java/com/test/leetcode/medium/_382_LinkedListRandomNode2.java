package com.test.leetcode.medium;

import com.test.leetcode.common.ListNode;

import java.util.Random;

/**
 * Created by ben on 2017/5/24.
 */
public class _382_LinkedListRandomNode2 {

    private ListNode h;
    private Random random;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public _382_LinkedListRandomNode2(ListNode head) {
        h = head;
        random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {

        ListNode head = h;
        int result = head.val;
        for (int i = 1; head != null; i++) {
            if (random.nextInt(i) == 0) {
                result = head.val;
            }

            head = head.next;
        }

        return result;
    }
}
