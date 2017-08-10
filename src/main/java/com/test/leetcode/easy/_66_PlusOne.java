package com.test.leetcode.easy;

/**
 * Created by ben on 2017/8/7.
 */
public class _66_PlusOne {
    public int[] plusOne(int[] digits) {
        if (null == digits || digits.length == 0) {
            return new int[]{0};
        }

        boolean biggerThan10;
        int temp;
        int index = digits.length - 1;
        temp = digits[index] + 1;
        if (temp == 10) {
            biggerThan10 = true;
            digits[index] = 0;
        } else {
            digits[index] = temp;
            return digits;
        }
        while (biggerThan10) {
            index--;
            if (index == -1) break;
            temp = digits[index] + 1;
            if (temp == 10) {
                biggerThan10 = true;
                digits[index] = 0;
            } else {
                biggerThan10 = false;
                digits[index] = temp;
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        for (int i = digits.length; i > 0; i--) {
            result[i] = digits[i - 1];
        }
        result[0] = 1;
        return result;
    }
}
