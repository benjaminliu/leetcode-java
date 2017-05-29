package com.test.leetcode.easy;

import com.test.leetcode.common.ListNode;

/**
 * Created by ben on 2017/5/30.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode temp = head;
        ListNode last = null;

        while (temp.next != null) {
            head = head.next;
            temp.next = last;
            last = temp;
            temp = head;
        }
        temp.next = last;
        return temp;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode newHead = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
