package com.test.leetcode.easy;

import com.test.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ben on 2017/8/13.
 */
public class _160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) return null;

        Set<ListNode> set = new HashSet<>();
        ListNode n1 = headA, n2 = headB;
        while (n2 != null) {
            set.add(n2);
            n2 = n2.next;
        }
        while (n1 != null) {
            if (!set.add(n1)) {
                return n1;
            }
            n1 = n1.next;
        }

        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }

            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }

        return pA;
    }

    //since they intersected, the tail is the same
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;

        ListNode p1 = headA;
        ListNode p2 = headB;

        if (p1 == null || p2 == null) {
            return null;
        }

        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }

        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }

        int diff = 0;
        p1 = headA;
        p2 = headB;

        if (len1 >= len2) {
            diff = len1 - len2;
            int i = 0;
            while (i < diff) {
                p1 = p1.next;
                i++;
            }
        } else {
            diff = len2 - len1;
            int j = 0;
            while (j < diff) {
                p2 = p2.next;
                j++;
            }
        }

        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }
}
