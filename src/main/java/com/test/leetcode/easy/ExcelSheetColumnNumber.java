package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/29.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum = c - 'A' + 1 + sum * 26;
        }
        return sum;
    }
}
