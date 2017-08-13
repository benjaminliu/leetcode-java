package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/13.
 */
public class _58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int i = len - 1;
        int length = 0;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') break;
            length++;
        }
        return length;
    }
}
