package com.test.leetcode.medium;

import com.test.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by ben on 2017/10/16.
 */
public class _147_InsertionSortList {


    //end to start
    public ListNode insertionSortList(ListNode head) {
        if (null == head) return head;

        List<ListNode> list = new ArrayList<>();
        ListNode cur = head.next;
        head.next = null;
        list.add(head);

        ListNode next, temp, tempNext;
        while (cur != null) {
            next = cur.next;
            boolean found = false;
            for (int i = list.size() - 1; i >= 0; i--) {
                temp = list.get(i);
                if (cur.val >= temp.val) {
                    list.add(i + 1, cur);
                    tempNext = temp.next;
                    temp.next = cur;
                    cur.next = tempNext;
                    found = true;
                    break;
                }
            }
            if (!found) {
                list.add(0, cur);
                cur.next = head;
                head = cur;
            }
            cur = next;
        }
        return head;
    }

    //start to end;
    public ListNode insertionSortList1(ListNode head) {
        if (null == head) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head.next;
        head.next  = null;
        ListNode temp,tempNext,next;
        while (null != cur) {
            next = cur.next;
            temp = dummy;
            while (null != temp.next &&temp.next.val< cur.val){
                temp  = temp.next;
            }
            tempNext = temp.next;
            temp.next = cur;
            cur.next = tempNext;
            cur = next;
        }
        return dummy.next;
    }
}
