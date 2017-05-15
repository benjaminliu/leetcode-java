package com.test.leetcode.easy;

/**
 * Created by ben on 2017/5/15.
 */
public class NumberComplement {
    public int findComplement(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Must be a positive num");
        }
        int sum = 0;
        int current = 0;
        int currentComp = 0;
        int bitSystem = 1;
        for (int i = 0; i < 32; i++) {
            if (num <= 0) {
                break;
            }
            current = num % 2;
            currentComp = current == 0 ? 1 : 0;
            if (i > 0) {
                bitSystem *= 2;
            }

            sum = sum + currentComp * bitSystem;
            num = num / 2;
        }
        return sum;
    }

    public int findComplement1(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Must be a positive num");
        }
        int sum = 0;
        int currentComp;
        int bitSystem = 1;
        for (int i = 0; i < 32; i++) {
            if (num <= 0) {
                break;
            }
            currentComp = (~num) & 1;

            if (i > 0) {
                bitSystem *= 2;
            }

            sum += currentComp * bitSystem;
            num = num >> 1;
        }
        return sum;
    }

    public int findComplement2(int num) {
        return ~num & (Integer.highestOneBit(num) - 1);
    }
}
