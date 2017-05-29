package com.test.leetcode.easy;

import com.test.leetcode.common.ListNode;

/**
 * Created by ben on 2017/5/30.
 */
public class DeleteNodeInaLinkedList {
    public void deleteNode(ListNode node) {
        if(null == node ||null == node.next){
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
