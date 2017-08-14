package com.test.leetcode.easy;

import com.test.leetcode.common.ListNode;

/**
 * Created by ben on 2017/8/14.
 */
public class _203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (null == head) return null;

        ListNode dummy1 = new ListNode(-1);
        dummy1.next = head;
        ListNode dummy = dummy1;
        while (dummy.next != null) {
            if (dummy.next.val == val) {
                dummy.next = dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }
        return dummy1.next;
    }
}
