package com.test.leetcode.easy;

import com.test.others.StringMatch_KMP;

/**
 * Created by ben on 2017/7/9.
 */
public class _8_StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        str = str.trim();

        int sign = 1;
        int index = 0;

        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        long rst = 0;//handle Integer overflow
        for (; index < str.length(); index++) {
            if (str.charAt(index) - '0' < 0 || str.charAt(index) - '0' > 9) {
                break;
            }
            rst = rst * 10 + (str.charAt(index) - '0');
            if (rst > Integer.MAX_VALUE) {
                break;
            }
        }

        rst = (sign == 1) ? rst : -rst;
        if (rst > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (rst < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) rst;
    }
}
