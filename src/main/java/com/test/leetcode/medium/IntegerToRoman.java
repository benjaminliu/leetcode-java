package com.test.leetcode.medium;

/**
 * Created by ben on 2017/5/31.
 */
public class IntegerToRoman {

    private static final String[] M = {"", "M", "MM", "MMM"};
    private static final String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int num) {
        if (num<=0||num>3999) {
            return "";
        }
        if (num < 10) {
            return I[num];
        } else if (num < 100) {
            return X[num / 10] + I[num % 10];
        } else if (num < 1000) {
            return C[num / 100] + X[(num % 100) / 10] + I[num % 10];
        } else {
            return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
        }
    }

    public String intToRoman1(int num) {
        if (num<=0||num>3999) {
            return "";
        }
        String str = null;
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int value[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; num != 0; ++i) {
            while (num >= value[i]) {
                num -= value[i];
                str += symbol[i];
            }
        }
        return str;
    }
}
