package com.test.leetcode.medium;

import com.test.leetcode.common.ListNode;

/**
 * Created by ben on 2017/7/9.
 */
public class _2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

        int carry = 0;
        int sum;
        ListNode header = null;
        ListNode temp = null;
        ListNode cur = null;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            l1 = l1.next;
            l2 = l2.next;

            if (sum > 9) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            temp = new ListNode(sum);
            if (cur == null) {
                cur = temp;
                header = temp;
            } else {
                cur.next = temp;
                cur = cur.next;
            }
        }

        while (l1 != null) {
            sum = l1.val + carry;
            l1 = l1.next;
            if (sum > 9) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            temp = new ListNode(sum);
            if (cur == null) {
                cur = temp;
                header = temp;
            } else {
                cur.next = temp;
                cur = cur.next;
            }
        }

        while (l2 != null) {
            sum = l2.val + carry;
            l2 = l2.next;
            if (sum > 9) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }
            temp = new ListNode(sum);
            if (cur == null) {
                cur = temp;
                header = temp;
            } else {
                cur.next = temp;
                cur = cur.next;
            }
        }
        if (carry == 1) {
            temp = new ListNode(1);
            cur.next = temp;
        }

        return header;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        if (l1 == null) return null;

        ListNode tmp = l1;

        int x;
        while (l1 != null) {
            x = l1.val + l2.val;
            if (x > 9) {
                l1.val = x % 10;
                if (l1.next == null) {
                    l1.next = new ListNode(1);
                    if (l2.next == null) l2.next = new ListNode(0);
                } else l1.next.val += 1;
            } else {
                l1.val = x;
            }

            if (l1.next == null && l2.next != null) l1.next = new ListNode(0);
            if (l2.next == null && l1.next != null) l2.next = new ListNode(0);

            l1 = l1.next;
            l2 = l2.next;
        }
        return tmp;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }
}
