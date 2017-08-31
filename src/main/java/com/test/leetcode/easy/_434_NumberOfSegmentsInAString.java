package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/23.
 */
public class _434_NumberOfSegmentsInAString {
    public int countSegments(String s) {
        if (null == s || s.length() == 0) return 0;

        int len = s.length();
        int idx = 0;

        while (idx < len && s.charAt(idx) == ' ') idx++;
        int count = 0;
        boolean lastIsBlank = false;
        for (; idx < len; idx++) {
            if (s.charAt(idx) == ' ') {
                if (lastIsBlank) {
                } else {
                    count++;
                }
                lastIsBlank = true;
            } else {
                lastIsBlank = false;
            }
        }
        if (s.charAt(len - 1) != ' ') count++;
        return count;
    }

    public int countSegments1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
}
