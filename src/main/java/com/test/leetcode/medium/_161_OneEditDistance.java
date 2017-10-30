package com.test.leetcode.medium;

/**
 * Created by ben on 2017/10/18.
 */
public class _161_OneEditDistance {

    //Given two strings S and T, determine if they are both one edit distance apart.
    public boolean isOneEditDistance(String s, String t) {

        int len1 = s.length();
        int len2 = t.length();
        if (len1 < len2) {
            return isOneEditDistance(t, s);
        }
        if (len1 - len2 > 1) {
            return false;
        }
        boolean flag = false;
        if (len1 == len2) {
            for (int i = 0; i < len1; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (!flag) {
                        flag = true;
                    } else {
                        return false;
                    }
                }
            }
            return flag;
        } else {
            int sStart = 0;
            int tStart = 0;
            while (tStart < len2) {
                if (s.charAt(sStart) == t.charAt(tStart)) {
                    tStart++;
                    sStart++;
                } else {
                    if (!flag) {
                        flag = true;
                        sStart++;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
