package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/30.
 */
public class Base7 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean nagitive = false;
        if (num < 0) {
            nagitive = true;
        }
        int res = 0;

        int base = 1;
        while (num != 0) {
            res += num % 7 * base;
            num = num / 7;
            base *= 10;
        }
        res = Math.abs(res);
        if (nagitive) {
            res *= -1;
        }
        return String.valueOf(res);
    }

    public String convertToBase71(int num) {
        return Integer.toString(num,7);
    }
}
