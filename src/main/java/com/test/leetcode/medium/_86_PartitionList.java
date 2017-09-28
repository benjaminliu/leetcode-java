package com.test.leetcode.medium;

import com.test.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/9/15.
 */
public class _86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (null == head) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;

        List<ListNode> smaller = new ArrayList<>();
        while (cur.next != null) {
            if (cur.next.val < x) {
                smaller.add(cur.next);
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        if (smaller.size() == 0) return head;

        cur = dummy;
        int idx = 0;
        ListNode temp;
        if (cur.next == null) {
            while (idx < smaller.size()) {
                temp = smaller.get(idx);
                cur.next = temp;
                cur = cur.next;
                idx++;
            }
        } else {
            while (cur.next != null && idx < smaller.size()) {
                temp = smaller.get(idx);
                if (cur.next.val >= temp.val) {
                    temp.next = cur.next;
                    cur.next = temp;
                    idx++;
                }
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
