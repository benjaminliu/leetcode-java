package com.test.leetcode.easy;

import com.test.leetcode.common.ListNode;

/**
 * Created by ben on 2017/8/13.
 */
public class _83_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = head;
        while (dummy.next != null) {
            if (dummy.val == dummy.next.val) {
                dummy.next = dummy.next.next;
            }else {
                dummy = dummy.next;
            }
        }
        return head;
    }
}
