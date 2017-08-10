package com.test.leetcode.easy;

import com.test.leetcode.common.ListNode;

/**
 * Created by ben on 2017/7/9.
 */
public class _21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

        ListNode idx1 = l1;
        ListNode idx2 = l2;
        ListNode temp;
        ListNode header = null;
        if (idx1.val <= idx2.val) {
            temp = header = idx1;
            idx1 = idx1.next;
        } else {
            temp = header = idx2;
            idx2 = idx2.next;
        }

        while (idx1 != null && idx2 != null) {
            if (idx1.val <= idx2.val) {
                temp.next = idx1;
                idx1 = idx1.next;
            } else {
                temp.next = idx2;
                idx2 = idx2.next;
            }
            temp = temp.next;
        }
        if (idx1 != null) {
            temp.next = idx1;
        }
        if (idx2 != null) {
            temp.next = idx2;
        }

        return header;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }
}
