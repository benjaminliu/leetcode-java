package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/13.
 */
public class _67_AddBinary {
    public String addBinary(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;

        StringBuilder sb = new StringBuilder();
        int a1;
        int b1;
        int sum;
        int increase = 0;
        final char zero = '0';

        int len1 = a.length();
        int len2 = b.length();
        int idx1 = len1-1;
        int idx2 = len2-1;
        while (idx1 >-1 && idx2>-1) {
            a1 = a.charAt(idx1) - zero;
            b1 = b.charAt(idx2) - zero;
            sum = a1 + b1 + increase;
            if (sum > 1) {
                increase = 1;
            } else {
                increase = 0;
            }
            sb.append(sum % 2);
            idx1--;
            idx2--;
        }
        while (idx1 >-1) {
            a1 = a.charAt(idx1) - zero;
            sum = a1 + increase;
            if (sum > 1) {
                increase = 1;
            } else {
                increase = 0;
            }
            sb.append(sum % 2);
            idx1--;
        }
        while (idx2>-1) {
            b1 = b.charAt(idx2) - zero;
            sum = b1 + increase;
            if (sum > 1) {
                increase = 1;
            } else {
                increase = 0;
            }
            sb.append(sum % 2);
            idx2--;
        }
        if (increase == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}
