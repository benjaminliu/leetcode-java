package com.test.leetcode.medium;

import com.test.leetcode.common.ListNode;

/**
 * Created by ben on 2017/9/15.
 */
public class _82_RemoveDuplicatesFromSortedList_II {
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode dulpStart, dulpEnd;
        while (cur.next != null) {
            dulpStart = cur.next;
            dulpEnd = dulpStart.next;
            if (dulpEnd == null) {
                cur = cur.next;
                continue;
            }
            if (dulpEnd.val == dulpStart.val) {
                //duplicate
                while (dulpEnd != null && dulpStart.val == dulpEnd.val) {
                    dulpEnd = dulpEnd.next;
                }
                if (dulpEnd == null) {
                    cur.next = null;
                } else {
                    cur.next = dulpEnd;
                }
            } else {
                //No duplicate
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
