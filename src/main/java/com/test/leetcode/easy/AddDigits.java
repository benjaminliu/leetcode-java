package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/27.
 */
public class AddDigits {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int temp = 0;

        while (true) {
            while (num >= 10) {
                temp += num % 10;
                num = num / 10;
            }
            temp += num;
            if (temp < 10) {
                return temp;
            }
            num = temp;
            temp = 0;
        }
    }
}
