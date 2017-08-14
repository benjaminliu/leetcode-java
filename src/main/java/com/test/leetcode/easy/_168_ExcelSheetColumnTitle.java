package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/14.
 */
public class _168_ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n <= 1) return "A";
        StringBuilder sb = new StringBuilder();
        int i;
        while (n != 0) {
            n--;
            i = n % 26;
            n /= 26;
            sb.append((char) (i + 'A'));
        }
        return sb.reverse().toString();
    }
}
