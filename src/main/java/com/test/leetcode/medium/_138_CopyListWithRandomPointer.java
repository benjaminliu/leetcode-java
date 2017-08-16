package com.test.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben on 2017/8/16.
 */
public class _138_CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (null == head) return head;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newH = new RandomListNode(head.label);
        map.put(head, newH);

        RandomListNode dummy = head;
        RandomListNode cur = newH;

        while (dummy.next != null) {
            dummy = dummy.next;
            cur.next = new RandomListNode(dummy.label);
            cur = cur.next;
            map.put(dummy, cur);
        }
        cur = newH;
        dummy = head;
        while (dummy != null) {
            if (dummy.random != null) {
                cur.random = map.get(dummy.random);
            }
            dummy = dummy.next;
            cur = cur.next;
        }
        return newH;
    }


    // Definition for singly-linked list with a random pointer.
    public static class RandomListNode {
        public int label;
        public RandomListNode next, random;

        public RandomListNode(int x) {
            this.label = x;
        }
    }

}
