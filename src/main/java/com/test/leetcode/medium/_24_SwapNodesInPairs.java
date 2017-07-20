package com.test.leetcode.medium;

import com.test.leetcode.common.ListNode;

/**
 * Created by ben on 2017/7/17.
 */
public class _24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode next = dummy;
        ListNode cur = dummy;
        ListNode temp;
        ListNode pre = dummy;

        while (true) {
            if (next.next != null && next.next.next != null) {
                cur = next.next;
                next = cur.next;
            } else {
                return dummy.next;
            }

            temp = next.next;
            next.next = cur;
            cur.next = temp;
            pre.next = next;

            cur = pre.next;
            next = cur.next;
            pre = next;
        }
    }
}
