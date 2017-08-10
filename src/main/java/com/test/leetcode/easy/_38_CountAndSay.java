package com.test.leetcode.easy;

import com.test.leetcode.common.ListNode;

/**
 * Created by ben on 2017/8/9.
 */
public class _38_CountAndSay {
    public String countAndSay(int n) {
        if (n < 1) return "";
        if (n == 1) return "1";
        ListNode dummy = new ListNode(0);
        dummy.next = new ListNode(1);
        ListNode temp, insert, pre, curPre;
        int idx = 1;
        int count;
        while (idx++ < n) {
            temp = dummy.next;
            count = 1;
            pre = dummy;
            curPre = dummy;
            while (temp != null) {
                if (temp.next != null) {
                    if (temp.next.val == temp.val) {
                        count++;
                        temp = temp.next;
                        curPre.next = temp;
                        continue;
                    }
                }
                insert = new ListNode(count);
                insert.next = pre.next;
                pre.next = insert;
                pre = temp;
                curPre= temp;
                temp = temp.next;
                count = 1;
            }
        }

        temp = dummy.next;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            sb.append(temp.val);
            temp = temp.next;
        }
        return sb.toString();
    }
}
