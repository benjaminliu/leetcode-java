package com.test.leetcode.medium;

import com.test.leetcode.common.ListNode;

/**
 * Created by ben on 2017/10/16.
 */
public class _148_SortList {
    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next) return head;

        ListNode mid = getMiddleNode(head);
        ListNode next = mid.next;
        mid.next = null;
        return mergeTwoList(sortList(head), sortList(next));
    }

    public ListNode mergeTwoList(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (null != a && null != b) {
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if (a == null) {
            cur.next = b;
        } else {
            cur.next = a;
        }
        return dummy.next;
    }

    public ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
