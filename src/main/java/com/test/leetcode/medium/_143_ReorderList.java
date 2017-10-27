package com.test.leetcode.medium;

import com.test.leetcode.common.ListNode;

/**
 * Created by ben on 2017/10/16.
 */
public class _143_ReorderList {
    public void reorderList(ListNode head) {
        if (null == head) return;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int len = 0;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            len++;
            if (fast.next != null) {
                fast = fast.next;
                len++;
            }
        }

        ListNode cur = slow.next;
        ListNode pre = null;
        ListNode temp;
        while (null != cur) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        slow.next = pre;

        ListNode back = slow.next;
        slow.next = null;
        cur = dummy.next;
        ListNode next;
        while (cur != slow) {
            next = cur.next;
            cur.next = back;
            back = back.next;
            cur = cur.next;
            cur.next = next;
            cur = cur.next;
        }
        if (null != back) {
            cur.next = back;
        }
    }
}
