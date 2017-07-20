package com.test.leetcode.hard;

import com.test.leetcode.common.ListNode;

/**
 * Created by ben on 2017/7/18.
 */
public class _25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head) {
            return null;
        }
        if (k < 2) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode startPrevious = dummy;
        ListNode endNext, next, cur, pre, end;
        endNext = dummy.next;


        while (true) {
            if(null == endNext){
                return dummy.next;
            }
            for (int i = 0; i < k - 1; i++) {
                if (null != endNext.next) {
                    endNext = endNext.next;
                } else {
                    return dummy.next;
                }
            }
            endNext = endNext.next;
            pre = endNext;

            cur = startPrevious.next;
            end = cur;
            next = cur.next;
            while (next != endNext) {
                cur.next = pre;
                pre = cur;
                cur = next;
                next = next.next;
            }
            cur.next = pre;
            startPrevious.next = cur;
            startPrevious = end;
        }
    }
}
