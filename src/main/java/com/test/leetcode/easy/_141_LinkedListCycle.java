package com.test.leetcode.easy;

import com.test.leetcode.common.ListNode;

/**
 * Created by ben on 2017/8/13.
 */
public class _141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (null == head) return false;

        ListNode fast = head;
        ListNode slow = head;

        while (true) {

            if (null == fast.next || null == fast.next.next) return false;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
    }
}
