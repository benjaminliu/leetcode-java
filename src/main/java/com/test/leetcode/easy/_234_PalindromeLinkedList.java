package com.test.leetcode.easy;

import com.test.leetcode.common.ListNode;

/**
 * Created by ben on 2017/8/15.
 */
public class _234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (null == head) return true;
        if (head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;

        ListNode fast = head, slow = head;
        int len = 1;

        while (fast.next != null) {
            fast = fast.next;
            len++;
            if (fast.next != null) {
                fast = fast.next;
            } else {
                break;
            }
            slow = slow.next;
        }
        ListNode next, cur, pre;
        pre = slow;
        cur = pre.next;
        next = cur.next;
        while (cur.next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = pre;

        pre = head;
        int idx = 1;
        while (idx++ <= len) {
            if (pre.val != cur.val) return false;
            pre = pre.next;
            cur = cur.next;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode prev = null, next = null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if (fast != null && fast.next == null) slow = slow.next;
        while (slow != null) {
            if (slow.val == prev.val) {
                slow = slow.next;
                prev = prev.next;
            } else return false;
        }
        return true;
    }

    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null)
            return true;
        if (head.val == head.next.val && head.next.next == null)
            return true;
        ListNode slow = head;
        ListNode cur = head.next;
        while (cur.next != null) {
            if (slow.val == cur.next.val) {
                if (cur.next.next != null)
                    return false;
                cur.next = null;
                slow = slow.next;
                cur = slow.next;
                if (cur == null || slow.val == cur.val)
                    return true;
            } else {
                cur = cur.next;
            }
        }
        return false;
    }
}
