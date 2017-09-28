package com.test.leetcode.medium;

import com.test.leetcode.common.ListNode;

/**
 * Created by ben on 2017/9/7.
 */
public class _61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head) return head;

        if (k == 0) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        int count = 0;
        int len = -1;
        while (k > 0) {
            if (null != fast.next) {
                if (len == -1) {
                    count++;
                }
                fast = fast.next;
            } else {
                len = count;
                k = k % len;
                if (k == 0) return head;
                fast = dummy.next;
            }
            k--;
        }

        ListNode slow = dummy;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow == dummy) return head;

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }

    public ListNode rotateRight1(ListNode head, int k) {

        if (head == null || k == 0) {
            return head;
        }

        ListNode iter = head;
        ListNode rotatedTail = head;

        int length = 0;

        while (iter != null) {
            iter = iter.next;
            length++;
        }

        k = k % length;

        if (k == 0) {
            return head;
        }

        for (int i = 0; i < length - k - 1; i++) {
            rotatedTail = rotatedTail.next;
        }

        ListNode rotatedHead = rotatedTail.next;
        rotatedTail.next = null;

        ListNode rotatedIter = rotatedHead;

        while (rotatedIter.next != null) {
            rotatedIter = rotatedIter.next;
        }

        rotatedIter.next = head;
        return rotatedHead;
    }
}
