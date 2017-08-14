package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/14.
 */
public class _125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (null == s || s.length() == 0) return true;
        if (s.length() == 1) return true;

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            int i = getAscii(s.charAt(start));
            while (i == -1) {
                start++;
                if (start >= end) return true;
                i = getAscii(s.charAt(start));
            }
            int j = getAscii(s.charAt(end));
            while (j == -1) {
                end--;
                if (start >= end) return true;
                j = getAscii(s.charAt(end));
            }
            if (start >= end) return true;

            if (i != j) return false;
            start++;
            end--;
        }
        return true;
    }

    private int getAscii(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        }
        if (c >= '0' && c <= '9') {
            return c - '0' + 26;
        }
        return -1;
    }


    private static char[] map = new char[256];

    static {
        for (int i = 0; i < 10; i++)
            map[i + '0'] = (char) (1 + i);
        for (int i = 0; i < 26; i++)
            map[i + 'a'] = map[i + 'A'] = (char) (11 + i);
    }

    public boolean isPalindrome1(String s) {
        char[] buf = s.toCharArray();

        int st = 0, e = s.length() - 1;
        char start, end;
        while (st < e) {
            start = map[buf[st]];
            end = map[buf[e]];
            if (start != 0 && end != 0) {
                if (start != end) return false;
                st++;
                e--;
            } else {
                if (start == 0) st++;
                if (end == 0) e--;
            }
        }

        return true;
    }
}
