package com.test.leetcode.hard;

import com.test.leetcode.common.ListNode;
import com.test.leetcode.easy._21MergeTwoSortedLists;

import java.util.PriorityQueue;

/**
 * Created by ben on 2017/7/9.
 */
public class _23MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length < 1) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));

        for (int i = 0; i < lists.length; i++) {
            if (null != lists[i]) {
                pq.add(lists[i]);
            }
        }
        ListNode header = pq.poll();
        ListNode temp = header;
        if (null != temp && null != temp.next) {
            pq.add(temp.next);
        }

        while (!pq.isEmpty()) {
            temp.next = pq.poll();
            temp = temp.next;

            if (temp.next != null) {
                pq.add(temp.next);
            }
        }
        return header;
    }

    private _21MergeTwoSortedLists m2 = new _21MergeTwoSortedLists();

    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists == null || lists.length == 0 ){
            return null;
        }
        return mergeKLists(lists,0,lists.length-1);
    }

    public ListNode mergeKLists(ListNode[] lists, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            return m2.mergeTwoLists(mergeKLists(lists, left, mid), mergeKLists(lists, mid + 1, right));
        }
        return lists[left];
    }
}
