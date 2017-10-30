package com.test.leetcode.medium;

import com.test.leetcode.common.ListNode;
import com.test.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/9/28.
 */
public class _109_ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {

        if (null == head) return null;

        List<Integer> values = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            values.add(cur.val);
            cur = cur.next;
        }

        TreeNode root = helper(values, 0, values.size() - 1);
        return root;
    }

    private TreeNode helper(List<Integer> values, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(values.get(mid));
            if (start < mid) {
                node.left = helper(values, start, mid - 1);
            }
            if (mid < end) {
                node.right = helper(values, mid + 1, end);
            }
            return node;
        }
        return null;
    }
}
