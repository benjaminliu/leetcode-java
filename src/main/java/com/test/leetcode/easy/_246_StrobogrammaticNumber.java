package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/15.
 */
public class _246_StrobogrammaticNumber {

    //A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

    //Write a function to determine if a number is strobogrammatic. The number is represented as a string.

    //For example, the numbers "69", "88", and "818" are all strobogrammatic.
    public boolean isStrobogrammatic(String num) {
        // 0, 1, 8   self strobogrammatic
        // 6, 9   pair strobogrammatic
        if (null == num || num.length() == 0) return true;

        char zero = '0';

        int start = 0;
        int end = num.length() - 1;
        int cs, ce;
        while (start <= end) {
            cs = num.charAt(start) - zero;
            ce = num.charAt(end) - zero;
            if (cs == 0 || cs == 1 || cs == 8) {
                if (cs != ce) return false;
            } else if (cs == 9) {
                if (ce != 6) return false;
            } else if (cs == 6) {
                if (ce != 9) return false;
            } else {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isStrobogrammatic1(String num) {
        char[] na = num.toCharArray();
        int i = 0, j = na.length - 1;
        while (i <= j) {
            if ((na[i] == '0' && na[j] == '0')
                    || (na[i] == '1' && na[j] == '1')
                    || (na[i] == '8' && na[j] == '8')
                    || (na[i] == '6' && na[j] == '9')
                    || (na[i] == '9' && na[j] == '6')) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
